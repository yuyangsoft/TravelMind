package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Timestamp;
import java.sql.Timestamp;

import com.cube.framework.base.BasePojo;

@Table(name = "TravelMind.T_USER_INFO")
public class UserInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public UserInfoPojo() {}
	public UserInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_PASS")
	private String userPass;

	@Column(name = "USER_STATES")
	private Integer userStates;

	@Column(name = "USER_FROM")
	private Integer userFrom;

	@Column(name = "USER_CREATEDATE")
	private Timestamp userCreatedate;

	@Column(name = "LAST_LONGINDATE")
	private Timestamp lastLongindate;

	@Column(name = "USER_IDENTIFIER")
	private String userIdentifier;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserPass() {
		return this.userPass;
	}

	public void setUserStates(Integer userStates) {
		this.userStates = userStates;
	}
	public Integer getUserStates() {
		return this.userStates;
	}

	public void setUserFrom(Integer userFrom) {
		this.userFrom = userFrom;
	}
	public Integer getUserFrom() {
		return this.userFrom;
	}

	public void setUserCreatedate(Timestamp userCreatedate) {
		this.userCreatedate = userCreatedate;
	}
	public Timestamp getUserCreatedate() {
		return this.userCreatedate;
	}

	public void setLastLongindate(Timestamp lastLongindate) {
		this.lastLongindate = lastLongindate;
	}
	public Timestamp getLastLongindate() {
		return this.lastLongindate;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
	public String getUserIdentifier() {
		return this.userIdentifier;
	}

}