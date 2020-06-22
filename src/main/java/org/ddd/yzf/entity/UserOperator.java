package org.ddd.yzf.entity;

import javax.persistence.*;

/**
 * @author 袁泽锋
 * @since 2019年12月27日 19:59
 * Description: TODO
 */
@Entity
@Table(name = "user_operator")
public class UserOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long uid;

    @Column(name = "user_id")
    protected Long userId;

    @Column(name = "operator_id")
    protected Long operatorId;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}
