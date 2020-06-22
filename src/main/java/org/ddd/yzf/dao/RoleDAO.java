package org.ddd.yzf.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ddd.yzf.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description: TODO
 *
 * @author 袁泽锋
 * @version 1.0
 * @since 2019/12/4 18:35
 */
@Mapper
@Component
public interface RoleDAO {

    Integer saveRole(Role role);

    List<Long> findAllRoleId();

    List<Role> findAllRole();

    List<Long> findRoleIdByOperatorId(@Param("operatorId") Long operatorId);

    Role findRoleByName(@Param("name")String name);
}
