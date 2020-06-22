package org.ddd.yzf.service.login.impl;

import org.ddd.yzf.dto.RequestDTO;
import org.ddd.yzf.dto.RespondDTO;
import org.ddd.yzf.dto.LoginUser;
import org.ddd.yzf.entity.Role;
import org.ddd.yzf.entity.Operator;
import org.ddd.yzf.entity.User;
import org.ddd.yzf.service.login.AccountService;
import org.ddd.yzf.service.operator.OperatorService;
import org.ddd.yzf.service.role.RoleService;
import org.ddd.yzf.service.user.UserService;
import org.ddd.yzf.system.config.RegexpConfig;
import org.ddd.yzf.util.MyTool;
import org.ddd.yzf.util.verification.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 袁泽锋
 * @since 2019年10月5日 10:12
 * Description: TODO
 */
@Service
public class AccountServiceBean implements AccountService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RegexpConfig regexpConfig;

    @Autowired
    private VerificationService verificationService;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;


    @Override
    public RespondDTO<Object> userLogin(RequestDTO<Object> requestDTO) {
        RespondDTO<Object> respondDTO = new RespondDTO<>();

        String account = requestDTO.getString("account");
        String password = requestDTO.getString("password");
        if (account == null || "".equals(account)) {
            respondDTO.putMsgData("isLogin", false);
            respondDTO.putMsgData("error", "数据异常，请确认您的输入");
            return respondDTO;
        }

        Operator operator = null;
        if (regexpConfig.getPhone().checkPhone(account)) {
            operator = this.operatorService.findOperatorByPhoneAndPassword(account, password);
        } else if (regexpConfig.getEmail().checkEmail(account)) {
            operator = this.operatorService.findOperatorByEmailAndPassword(account, password);
        } else {
            operator = this.operatorService.findOperatorByAccountAndPassword(account, password);
        }


        if (operator == null) {
            respondDTO.putMsgData("isLogin", false);
            respondDTO.putMsgData("error", "账户或密码错误!");
            return respondDTO;
        } else {
            respondDTO.putMsgData("isLogin", true);
            User user = this.userService.findUserForLogin(operator.getUid());
            if (user == null) {
                user = new User();
                user.setUid(-1L);
                user.setName("未知");
            }

            respondDTO.putMsgData("user", user);

            LoginUser loginUser = new LoginUser();
            loginUser.setOperatorId(operator.getUid());
            loginUser.setUserId(user.getUid());
            loginUser.setRoleIds(roleService.findRoleIdByOperatorId(operator.getUid()));
            request.getSession().invalidate();
            request.getSession().setAttribute("loginUser", loginUser);

            List<String> permissions = new ArrayList<>();
            respondDTO.putMsgData("permissions", permissions);
        }
        return respondDTO;
    }

    @Override
    public void userLogout() {
        request.getSession().invalidate();
    }


    private Operator creatOperator(String name, String account, String password) {
        Operator operator = new Operator();
        operator.setName(name);
        operator.setAccount(account);
        operator.setPassword(password);
        operator.setStatus("在用");
        return operator;
    }

    private User creatStudentUser(String name, String phone, String email) {
        User studentUser = new User();
        studentUser.setName(name);
        studentUser.setPhone(phone);
        studentUser.setEmail(email);
        studentUser.setType("student");
        studentUser.setStatus("在用");
        return studentUser;
    }


    private User creatTeacherUser(String name, String phone, String email) {
        User studentUser = new User();
        studentUser.setName(name);
        studentUser.setPhone(phone);
        studentUser.setEmail(email);
        studentUser.setType("teacher");
        studentUser.setStatus("在用");
        return studentUser;
    }

}
