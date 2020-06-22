package org.ddd.yzf.controller;

import org.ddd.yzf.dto.FileUploadDTO;
import org.ddd.yzf.dto.RequestDTO;
import org.ddd.yzf.dto.RespondDTO;
import org.ddd.yzf.service.annex.AnnexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/annex")
@CrossOrigin(allowCredentials = "true")
public class AnnexController {

    @Autowired
    private AnnexService annexService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @PostMapping("/upload")
    public RequestDTO upload(FileUploadDTO fileUploadDTO, List<MultipartFile> files) {
        System.out.println(files);
        return null;
    }

    @PostMapping("/uploadStudentImg")
    public RespondDTO uploadStudentImg(FileUploadDTO fileUploadDTO, List<MultipartFile> files) {
        return annexService.uploadStudentImg(fileUploadDTO, files);
    }

    @GetMapping("/delStudentImg")
    public String delStudentImg(@RequestParam String fileName) {
        return this.annexService.delStudentImg(fileName);
    }

    @GetMapping("/getStudentImg")
    public void getStudentImg(@RequestParam String fileName) {
        this.annexService.getStudentImg(request, response, fileName);
    }

}
