package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.cube.framework.base.BasePojo;

@Table(name = "TravelMind.T_ROLE_INFO")
public class RoleInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public RoleInfoPojo() {}
	public RoleInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "ROLE_NAME")
	private String roleName;

	@Column(name = "ROLE_DESC")
	private String roleDesc;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getRoleDesc() {
		return this.roleDesc;
	}

}