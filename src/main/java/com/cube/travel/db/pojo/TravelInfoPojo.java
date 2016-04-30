package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Date;

import com.cube.framework.base.BasePojo;

@Table(name = "TravelMind.T_TRAVEL_INFO")
public class TravelInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public TravelInfoPojo() {}
	public TravelInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TRAVEL_NAME")
	private String travelName;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "USERE_ID")
	private Integer usereId;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setTravelName(String travelName) {
		this.travelName = travelName;
	}
	public String getTravelName() {
		return this.travelName;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getStartDate() {
		return this.startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getEndDate() {
		return this.endDate;
	}

	public void setUsereId(Integer usereId) {
		this.usereId = usereId;
	}
	public Integer getUsereId() {
		return this.usereId;
	}

}