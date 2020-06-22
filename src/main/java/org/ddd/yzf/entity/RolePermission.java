package org.ddd.yzf.entity;

import javax.persistence.*;

/**
 * @author 袁泽锋
 * @since 2019年12月27日 19:59
 * Description: TODO
 */
@Entity
@Table(name = "role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long uid;

    @Column(name = "role_id")
    protected Long roleId;

    @Column(name = "permission_id")
    protected Long permissionId;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
