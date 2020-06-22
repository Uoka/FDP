package org.ddd.yzf.service.annex.impl;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.ddd.yzf.system.config.SystemConfig;
import org.ddd.yzf.dao.AnnexDAO;
import org.ddd.yzf.dto.FileUploadDTO;
import org.ddd.yzf.dto.RespondDTO;
import org.ddd.yzf.entity.Annex;
import org.ddd.yzf.service.annex.AnnexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Service
public class AnnexServiceBean implements AnnexService {

    @Autowired
    private AnnexDAO annexDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RespondDTO uploadStudentImg(FileUploadDTO fileUploadDTO, List<MultipartFile> files) {
        RespondDTO respondDTO = new RespondDTO();
        respondDTO.putMsgData("res", false);

        // 保存文件
        if (files != null && !files.isEmpty()) {

            Annex annex = fileUploadDTO.getAnnex();
            annex.setUploaderId(1L);
            annex.setUploadTime(new Date());

            annex.setRelativePath("/studentImg");

            MultipartFile multipartFile = files.get(0);
            if (!multipartFile.isEmpty()) {
                annex.setSize(multipartFile.getSize());
                String oldFileName = multipartFile.getOriginalFilename();
                if (oldFileName == null) {
                    oldFileName = "img.jpg";
                }
                annex.setFormerName(oldFileName);
                annex.setSuffixName(oldFileName.substring(oldFileName.lastIndexOf(".")));

//                String randomStr = UUID.randomUUID().toString();
//                String newFileName = randomStr + oldFileName.substring(oldFileName.lastIndexOf("."));

                annex.setSavedName(annex.getFieldId() + annex.getSuffixName());

                File file = new File(SystemConfig.defPath + SystemConfig.uploadPath + annex.getRelativePath(),
                        annex.getSavedName());
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                try {
                    multipartFile.transferTo(file);
                    Annex oldAnnex = annexDAO.getAnnexByKey(annex.getFieldId(), annex.getTableName());
                    if (oldAnnex == null) {
                        annexDAO.addAnnex(annex);
                    } else {
                        annex.setUid(oldAnnex.getUid());
                        annexDAO.updateAnnex(annex);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return respondDTO;
    }

    @Override
    public void getStudentImg(HttpServletRequest request, HttpServletResponse response, String fileName) {
        File imgFile = new File(SystemConfig.defPath + SystemConfig.uploadPath + "/studentImg", fileName);

        if (imgFile.exists()) {

            OutputStream toClient = null;
            InputStream fis = null;
            try {
                // 清空response
                response.reset();
                // 设置response的Header
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(imgFile.getName(), "UTF-8"));
                response.addHeader("Content-Length", "" + imgFile.length());
                response.setContentType("application/octet-stream");
                response.setCharacterEncoding(request.getCharacterEncoding());

                toClient = new BufferedOutputStream(response.getOutputStream());
                fis = new BufferedInputStream(new FileInputStream(imgFile));
                IOUtils.copy(fis, response.getOutputStream());
                fis.close();
                toClient.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(fis);
                IOUtils.closeQuietly(toClient);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String delStudentImg(String fileName) {
        File imgFile = new File(SystemConfig.defPath + SystemConfig.uploadPath + "/studentImg", fileName);

        if (imgFile.exists()) {
            try {
                if (imgFile.delete()) {
                    Long studentId = Long.valueOf(fileName.split("\\.")[0]);
                    annexDAO.delAnnexByKey(studentId, "student");
                    return "文件删除成功";
                } else {
                    return "文件删除失败";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "文件已被删除";
    }

}
