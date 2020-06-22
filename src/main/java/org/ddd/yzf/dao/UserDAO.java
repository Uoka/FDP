package org.ddd.yzf.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ddd.yzf.entity.User;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDAO {

    Integer addUser(User user);

    void setUserOperator(@Param("userId") Long userId, @Param("operatorId") Long operatorId);

    User findUserForLogin(@Param("operatorId") Long operatorId);
}
