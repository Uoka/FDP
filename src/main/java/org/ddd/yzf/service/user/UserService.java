package org.ddd.yzf.service.user;

import org.ddd.yzf.entity.User;

public interface UserService {

    void addUser(User user);

    User findUserForLogin(Long operatorId);

    void setUserOperator(Long userId, Long operatorId);
}
