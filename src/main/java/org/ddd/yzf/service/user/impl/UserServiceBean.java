package org.ddd.yzf.service.user.impl;

import org.ddd.yzf.dao.UserDAO;
import org.ddd.yzf.entity.User;
import org.ddd.yzf.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 袁泽锋
 * @since 2019年12月27日 19:16
 * Description: TODO
 */
@Service
public class UserServiceBean implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findUserForLogin(Long operatorId) {
        if (operatorId != null && operatorId > 0) {
            return this.userDAO.findUserForLogin(operatorId);
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        this.userDAO.addUser(user);
    }

    @Override
    public void setUserOperator(Long userId, Long operatorId) {
        this.userDAO.setUserOperator(userId, operatorId);
    }
}
