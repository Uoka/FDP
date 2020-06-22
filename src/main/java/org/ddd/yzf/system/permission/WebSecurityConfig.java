package org.ddd.yzf.system.permission;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ddd.yzf.system.config.SystemConfig;
import org.ddd.yzf.dto.LoginUser;
import org.ddd.yzf.util.MyTool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 袁泽锋
 * @ClassName: WebSecurityConfig
 * @Description: 安全设置
 * @date 2019年10月5日
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
    private static Logger logger = LogManager.getLogger();

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // TODO 排除测试路径
        addInterceptor.excludePathPatterns("/test/**");
        addInterceptor.excludePathPatterns("/**");
        addInterceptor.addPathPatterns();
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Headers", "authorization, Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
            if (request.getMethod().equals("OPTIONS")) {
                response.setStatus(200);
                response.getWriter().write("OPTIONS returns OK");
                return true;
            }

            HttpSession session = request.getSession();
            String uri = request.getRequestURI();
            String ipAddress = MyTool.getIpAddress(request);

            // 判断是否访问白名单
            if (SystemConfig.whiteURLs != null && SystemConfig.whiteURLs.contains(uri)) {
                return true;
            }

            LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
            // 判断是否有权限
            if (loginUser != null) {
                if (SystemPermissionManager.roleHasPermission(loginUser.getRoleIds(), uri)) {
                    return true;
                } else {
                    logger.warn("来自{}的非法请求，请求的接口{}\n用户信息：{}\n可能是恶意攻击，请报告管理员",
                            ipAddress,  JSONObject.toJSONString(loginUser), uri);
                    response.setStatus(401);
                    return false;
                }
            }

            logger.warn("来自{}的非法请求，请求的接口{},可能是恶意攻击，请报告管理员", ipAddress, uri);
            response.setStatus(401);
            return false;
        }
    }
}
