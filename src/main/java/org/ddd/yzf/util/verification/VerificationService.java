package org.ddd.yzf.util.verification;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface VerificationService {
    /**
     * 获取验证码
     *
     * @param request  request
     * @param response response
     * @throws IOException IOException
     */
    void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException;
    /**
     * 验证码校验
     *
     * @param input 验证码
     * @return 结果
     */
    boolean checkCaptcha(String input);
}
