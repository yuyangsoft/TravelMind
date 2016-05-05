package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Timestamp;

import com.cube.framework.base.BasePojo;

@Table(name = "realgame.t_mission_info")
public class MissionInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public MissionInfoPojo() {}
	public MissionInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "MISSION_NAME")
	private String missionName;

	@Column(name = "MISSION_DESC")
	private String missionDesc;

	@Column(name = "MISSION_REWARD")
	private String missionReward;

	@Column(name = "MISSION_STATE")
	private Integer missionState;

	@Column(name = "MISSION_TYPE")
	private Integer missionType;

	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	public String getMissionName() {
		return this.missionName;
	}

	public void setMissionDesc(String missionDesc) {
		this.missionDesc = missionDesc;
	}
	public String getMissionDesc() {
		return this.missionDesc;
	}

	public void setMissionReward(String missionReward) {
		this.missionReward = missionReward;
	}
	public String getMissionReward() {
		return this.missionReward;
	}

	public void setMissionState(Integer missionState) {
		this.missionState = missionState;
	}
	public Integer getMissionState() {
		return this.missionState;
	}

	public void setMissionType(Integer missionType) {
		this.missionType = missionType;
	}
	public Integer getMissionType() {
		return this.missionType;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getCreateDate() {
		return this.createDate;
	}

}