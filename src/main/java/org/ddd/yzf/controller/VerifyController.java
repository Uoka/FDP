package org.ddd.yzf.controller;

import org.ddd.yzf.util.verification.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: VerifyController
 * Description: VerifyController
 * Author: 袁泽锋
 * Date: 2019/6/27 0:01
 * Version: 1.0
 **/
@RestController
@RequestMapping("/verifyController")
@CrossOrigin(allowCredentials = "true")
public class VerifyController {

    private final VerificationService verificationService;

    @Autowired
    public VerifyController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @GetMapping("getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.verificationService.getCaptcha(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
