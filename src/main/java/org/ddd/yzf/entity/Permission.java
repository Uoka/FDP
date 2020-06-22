package org.ddd.yzf.entity;


import javax.persistence.*;
import java.util.List;

/**
 * @ClassName: Permission
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 袁泽锋
 * @date 2019年10月5日
 *
 */
@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long uid;

    @Column(name = "code", unique=true)
    protected String code;

    @Column(name = "name")
    protected String name;

    @Column(name = "remark")
    protected String remark;

    @Transient
    protected List<PermissionLine> permissionLines;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<PermissionLine> getPermissionLines() {
        return permissionLines;
    }

    public void setPermissionLines(List<PermissionLine> permissionLines) {
        this.permissionLines = permissionLines;
    }
}
