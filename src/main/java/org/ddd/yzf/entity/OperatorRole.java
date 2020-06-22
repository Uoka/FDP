package org.ddd.yzf.entity;

import javax.persistence.*;

/**
 * @author 袁泽锋
 * @since 2019年12月27日 19:59
 * Description: TODO
 */
@Entity
@Table(name = "operator_role")
public class OperatorRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long uid;

    @Column(name = "operator_id")
    protected Long operatorId;

    @Column(name = "role_id")
    protected Long roleId;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
