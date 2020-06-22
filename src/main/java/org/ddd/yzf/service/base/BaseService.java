package org.ddd.yzf.service.base;

import org.ddd.yzf.dto.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface BaseService {

    /**
     * Description: 获取登录用户
     * @author 袁泽锋
     * @since 2020/6/13 14:59
     * @return org.ddd.yzf.dto.LoginUser
     */
    LoginUser getLoginUser();

    /**
     * Description: 获取登录用户的Id
     * @author 袁泽锋
     * @since 2020/6/13 14:59
     * @return java.lang.Long
     */
    Long getLoginUserId();

    /**
     * Description: 获取request
     * @author 袁泽锋
     * @since 2020/6/13 14:59
     * @return javax.servlet.http.HttpServletRequest
     */
    HttpServletRequest getRequest();

    /**
     * Description: 获取response
     * @author 袁泽锋
     * @since 2020/6/13 14:59
     * @return javax.servlet.http.HttpServletResponse
     */
    HttpServletResponse getResponse();

   /**
    * Description: 获取系统所有的URl接口
    * @author 袁泽锋
    * @since 2020/6/19 15:53
    * @return java.util.List<java.util.Map < java.lang.String, java.lang.String>>
    */
    List<Map<String, String>> getAllAPI();

}
