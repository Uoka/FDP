package org.ddd.yzf.service.role.impl;

import org.ddd.yzf.dao.RoleDAO;
import org.ddd.yzf.entity.Role;
import org.ddd.yzf.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: TODO
 *
 * @author 袁泽锋
 * @version 1.0
 * @since 2019/12/4 20:08
 */
@Service
public class RoleServiceBean implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<Long> findRoleIdByOperatorId(Long operatorId) {
        return roleDAO.findRoleIdByOperatorId(operatorId);
    }

    @Override
    public List<Role> findAllRole() {
        return this.roleDAO.findAllRole();
    }

    @Override
    public void addRole(Role role) {
        this.roleDAO.saveRole(role);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleDAO.findRoleByName(name);
    }
}
