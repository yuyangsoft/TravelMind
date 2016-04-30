package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.cube.framework.base.BasePojo;

@Table(name = "TravelMind.T_USER_ROLE")
public class UserRolePojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public UserRolePojo() {}
	public UserRolePojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "ROLE_ID")
	private Integer roleId;

	@Column(name = "IS_DEFAULT")
	private Integer isDefault;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public Integer getIsDefault() {
		return this.isDefault;
	}

}