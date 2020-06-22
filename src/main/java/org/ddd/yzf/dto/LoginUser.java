package org.ddd.yzf.dto;

import java.util.List;

/**
 * @ClassName: LoginUser
 * @Description: 登录用户
 * @author 袁泽锋
 * @date 2019年10月5日
 *
 */
public class LoginUser {

	protected String userName;

	protected String operatorName;

	protected Long userId;

	protected Long operatorId;

	protected List<Long> roleIds;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
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

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}
}
