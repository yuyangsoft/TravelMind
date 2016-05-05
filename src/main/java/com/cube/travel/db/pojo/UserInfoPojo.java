package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Timestamp;

import com.cube.framework.base.BasePojo;

@Table(name = "realgame.t_user_info")
public class UserInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public UserInfoPojo() {}
	public UserInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "UUID")
	private String uuid;

	@Column(name = "LOGIN_NAME")
	private String loginName;

	@Column(name = "LOGIN_PASS")
	private String loginPass;

	@Column(name = "USER_STATES")
	private Integer userStates;

	@Column(name = "USER_LEVEL")
	private Integer userLevel;

	@Column(name = "USER_FROM")
	private Integer userFrom;

	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	@Column(name = "LAST_LOGIN_DATE")
	private Timestamp lastLoginDate;

	@Column(name = "USER_EXP")
	private Long userExp;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUuid() {
		return this.uuid;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getLoginPass() {
		return this.loginPass;
	}

	public void setUserStates(Integer userStates) {
		this.userStates = userStates;
	}
	public Integer getUserStates() {
		return this.userStates;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public Integer getUserLevel() {
		return this.userLevel;
	}

	public void setUserFrom(Integer userFrom) {
		this.userFrom = userFrom;
	}
	public Integer getUserFrom() {
		return this.userFrom;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setUserExp(Long userExp) {
		this.userExp = userExp;
	}
	public Long getUserExp() {
		return this.userExp;
	}

}