package org.ddd.yzf.service.annex;

import org.ddd.yzf.dto.FileUploadDTO;
import org.ddd.yzf.dto.RespondDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface AnnexService {

    RespondDTO uploadStudentImg(FileUploadDTO fileUploadDTO, List<MultipartFile> files);

    void getStudentImg(HttpServletRequest request, HttpServletResponse response, String fileName);

    String delStudentImg(String fileName);
}
