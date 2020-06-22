package org.ddd.yzf.service.role;

import org.ddd.yzf.entity.Role;

import java.util.List;

public interface RoleService {

    List<Long> findRoleIdByOperatorId(Long operatorId);

    List<Role> findAllRole();

    void addRole(Role role);


    Role findRoleByName(String name);
}
