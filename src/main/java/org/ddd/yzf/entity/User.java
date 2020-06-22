package org.ddd.yzf.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 袁泽锋
 * @date 2019年10月5日
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@Column(name = "uid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long uid;

	@Column(name = "name")
	protected String name;

	@Column(name = "sex")
	protected String sex;

	@Column(name = "phone", unique=true)
	protected String phone;

	@Column(name = "email", unique=true)
	protected String email;

	@Column(name = "type")
	protected String type;

	@Column(name = "status")
	protected String status;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
