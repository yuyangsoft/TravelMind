package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.cube.framework.base.BasePojo;

@Table(name = "realgame.t_role_info")
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

	@Column(name = "ROLE_STATES")
	private Integer roleStates;

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

	public void setRoleStates(Integer roleStates) {
		this.roleStates = roleStates;
	}
	public Integer getRoleStates() {
		return this.roleStates;
	}

}