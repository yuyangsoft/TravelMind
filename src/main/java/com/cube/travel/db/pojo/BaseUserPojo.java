package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Timestamp;

import com.cube.framework.base.BasePojo;

@Table(name = "TravelMind.t_base_user")
public class BaseUserPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public BaseUserPojo() {}
	public BaseUserPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_pass")
	private String userPass;

	@Column(name = "user_state")
	private Integer userState;

	@Column(name = "user_from")
	private Integer userFrom;

	@Column(name = "user_UUID")
	private String userUuid;

	@Column(name = "user_createdate")
	private Timestamp userCreatedate;

	@Column(name = "user_type")
	private Integer userType;

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

	public void setUserState(Integer userState) {
		this.userState = userState;
	}
	public Integer getUserState() {
		return this.userState;
	}

	public void setUserFrom(Integer userFrom) {
		this.userFrom = userFrom;
	}
	public Integer getUserFrom() {
		return this.userFrom;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}
	public String getUserUuid() {
		return this.userUuid;
	}

	public void setUserCreatedate(Timestamp userCreatedate) {
		this.userCreatedate = userCreatedate;
	}
	public Timestamp getUserCreatedate() {
		return this.userCreatedate;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getUserType() {
		return this.userType;
	}

}