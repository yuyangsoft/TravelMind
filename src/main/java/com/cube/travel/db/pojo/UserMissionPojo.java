package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Timestamp;

import com.cube.framework.base.BasePojo;

@Table(name = "realgame.t_user_mission")
public class UserMissionPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public UserMissionPojo() {}
	public UserMissionPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "MISSION_ID")
	private Integer missionId;

	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "OPT_TYPE")
	private Integer optType;

	@Column(name = "OPT_DATE")
	private Timestamp optDate;

	@Column(name = "OPT_STATE")
	private Integer optState;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}
	public Integer getMissionId() {
		return this.missionId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setOptType(Integer optType) {
		this.optType = optType;
	}
	public Integer getOptType() {
		return this.optType;
	}

	public void setOptDate(Timestamp optDate) {
		this.optDate = optDate;
	}
	public Timestamp getOptDate() {
		return this.optDate;
	}

	public void setOptState(Integer optState) {
		this.optState = optState;
	}
	public Integer getOptState() {
		return this.optState;
	}

}