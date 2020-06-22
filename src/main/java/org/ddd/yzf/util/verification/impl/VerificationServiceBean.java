package org.ddd.yzf.util.verification.impl;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.ddd.yzf.util.verification.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

/**
 * ClassName: VerificationService
 * Description: VerificationService
 * Author: 袁泽锋
 * Date: 2019/6/26 23:53
 * Version: 1.0
 **/
@Service
@Transactional
public class VerificationServiceBean implements VerificationService {

    private final Producer captchaProducer;

    private final HttpServletRequest request;

    @Autowired
    public VerificationServiceBean(Producer captchaProducer, HttpServletRequest request) {
        this.captchaProducer = captchaProducer;
        this.request = request;
    }


    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //生成验证码
        String capText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        session.setAttribute(Constants.KAPTCHA_SESSION_DATE, new Date());
        //向客户端写出
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }

    }

    /**
     * 验证码校验
     *
     * @param input 验证码
     * @return 结果
     */
    public boolean checkCaptcha(String input) {
        //获取生成的验证码
        HttpSession session = this.request.getSession();
        String verifyCodeExpected = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        Date buildDate = (Date) session.getAttribute(Constants.KAPTCHA_SESSION_DATE);
        //验证验证码
        if (verifyCodeExpected != null && buildDate != null && new Date().getTime() - buildDate.getTime() < 300_000L) {
            return verifyCodeExpected.equals(input.toUpperCase());
        }
        return false;
    }


}
