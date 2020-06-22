package org.ddd.yzf.entity;


import javax.persistence.*;

/**
 * @ClassName: Role
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 袁泽锋
 * @date 2019年10月5日
 *
 */
@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long uid;

	@Column(name = "name", unique = true)
	protected String name;

	@Column(name = "remark")
	protected String remark;

	/**
	 * @return the uid
	 */
	public Long getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
