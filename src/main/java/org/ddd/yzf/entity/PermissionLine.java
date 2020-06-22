package org.ddd.yzf.entity;

import javax.persistence.*;

/**
 * Description: 权限条目
 *
 * @author 袁泽锋
 * @version 1.0
 * @since 2019/12/4 19:07
 */
@Entity
@Table(name = "permission_line")
public class PermissionLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long uid;

    @Column(name = "permission_id")
    protected Long permissionId;

    @Column(name = "api_URL")
    protected String apiURL;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }
}
