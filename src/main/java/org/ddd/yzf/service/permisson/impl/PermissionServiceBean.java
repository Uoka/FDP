package org.ddd.yzf.service.permisson.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ddd.yzf.dao.PermissionDAO;
import org.ddd.yzf.dto.RequestDTO;
import org.ddd.yzf.dto.RespondDTO;
import org.ddd.yzf.entity.*;
import org.ddd.yzf.service.base.BaseService;
import org.ddd.yzf.service.operator.OperatorService;
import org.ddd.yzf.service.permisson.PermissionService;
import org.ddd.yzf.service.role.RoleService;
import org.ddd.yzf.service.user.UserService;
import org.ddd.yzf.system.permission.SystemPermissionManager;
import org.ddd.yzf.util.MyTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 袁泽锋
 * @ClassName: PermissionServiceBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2019年10月5日
 */
@Service
public class PermissionServiceBean implements PermissionService {
    private static Logger logger = LogManager.getLogger();

    @Autowired
    private PermissionDAO permissionDAO;

    @Autowired
    private RoleService roleService;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private UserService userService;

    @Autowired
    private BaseService baseService;


    @Override
    public RespondDTO<Object> addPermission(RequestDTO<PermissionLine> requestDTO) {

        RespondDTO<Object> respondDTO = new RespondDTO<>();
        String name = requestDTO.getString("name");
        if (name == null || "".endsWith(name)) {
            respondDTO.putMsgData("result", false);
            respondDTO.putMsgData("error", "名称数据格式错误");
        }
        String code = requestDTO.getString("code");
        if (code == null || "".endsWith(code)) {
            respondDTO.putMsgData("result", false);
            respondDTO.putMsgData("error", "编码数据格式错误");
        }
        String remark = requestDTO.getString("remark");
        Permission permission = new Permission();
        permission.setCode(code);
        permission.setName(name);
        permission.setRemark(remark);

        this.permissionDAO.addPermission(permission);
        List<PermissionLine> permissionLineList = requestDTO.getObjList();
        permissionLineList.forEach(permissionLine -> {
            permissionLine.setPermissionId(permission.getUid());
        });
        this.permissionDAO.addPermissionLineList(permissionLineList);

        return respondDTO;
    }

    @Override
    public RespondDTO<Permission> getPermissionListData(RequestDTO<Object> requestDTO) {
        Integer pageSize = requestDTO.getInteger("pageSize");
        Integer startIndex = (requestDTO.getInteger("currentPage") - 1) * pageSize;
        String filterSql = "(uid like '%')";
        String sortSql = "uid";

        List<Permission> permissions = this.permissionDAO.getPermissionForPage(startIndex, pageSize, filterSql, sortSql);
        Long totalCount = this.permissionDAO.getTotalCountForPage(filterSql);

        RespondDTO<Permission> respondDTO = new RespondDTO<>();
        respondDTO.setObjList(permissions);
        respondDTO.putMsgData("totalCount", totalCount);
        return respondDTO;
    }

    @Override
    public Boolean delPermissionById(Long uid) {
        return null;
    }

    @Override
    public void batchDeletion(RequestDTO<Long> requestDTO) {

    }

    @Override
    public RespondDTO<Object> updatePermission(RequestDTO<Permission> requestDTO) {
        return null;
    }

    @Override
    public RespondDTO<Permission> getPermissionWithLineById(Long uid) {
        RespondDTO<Permission> respondDTO = new RespondDTO<>();
        Permission permission = this.permissionDAO.findPermissionById(uid);
        if (permission != null) {
            List<PermissionLine> permissionLines = this.permissionDAO.findLinesByPermissionId(permission.getUid());
            permission.setPermissionLines(permissionLines);
            respondDTO.setObjList(new ArrayList<Permission>() {
                {
                    add(permission);
                }
            });
        }
        return respondDTO;
    }

    @Override
    public List<String> findPermissionByRoleId(Long roleId) {
        return permissionDAO.findPermissionsByRoleId(roleId);
    }

    @Override
    public void updateSystemPermissionData() {
        List<Role> roleIdList = this.roleService.findAllRole();
        Map<Long, List<String>> rolePermission = new HashMap<>();
        long adminId = -1L;
        for (Role role : roleIdList) {
            if ("超级管理员".endsWith(role.getName())) {
                adminId = role.getUid();
                continue;
            }
            List<String> permissions = this.findPermissionByRoleId(role.getUid());
            rolePermission.put(role.getUid(), permissions);
        }
        SystemPermissionManager.setRolesURLMap(rolePermission);
        if (adminId == -1L) {
            adminId = createAdministrator();
        }
        SystemPermissionManager.setSuperAdministratorId(adminId);
        logger.info("update system permission data");
    }

    private long createAdministrator() {
        Role administratorRole = new Role();
        administratorRole.setName("超级管理员");
        administratorRole.setRemark("创建于：" + new Date());
        this.roleService.addRole(administratorRole);

        Operator administratorOperator = new Operator();
        administratorOperator.setName("超级管理员");
        administratorOperator.setAccount("000");
        administratorOperator.setPassword(MyTool.MD5Crypt("000"));
        administratorOperator.setStatus("在用");
        this.operatorService.addOperator(administratorOperator);
        this.operatorService.setOperatorRole(administratorOperator.getUid(), administratorRole.getUid());

        User user = new User();
        user.setName("超级管理员");
        user.setStatus("在用");
        user.setType("employee");
        this.userService.addUser(user);
        this.userService.setUserOperator(user.getUid(), administratorOperator.getUid());

        return administratorRole.getUid();
    }

    @Override
    public List<Map<String, String>> getAllAPI() {
        return baseService.getAllAPI();
    }
}
