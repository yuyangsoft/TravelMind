package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Timestamp;

import com.cube.framework.base.BasePojo;

@Table(name = "TravelMind.T_TRAVEL_POINT")
public class TravelPointPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public TravelPointPojo() {}
	public TravelPointPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TRAVEL_ID")
	private Integer travelId;

	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "COUNTRY_ID")
	private Integer countryId;

	@Column(name = "CITY_ID")
	private Integer cityId;

	@Column(name = "POINT_LNG_LAT")
	private String pointLngLat;

	@Column(name = "POINT_TYPE")
	private Integer pointType;

	@Column(name = "POINT_DESC")
	private String pointDesc;

	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
	}
	public Integer getTravelId() {
		return this.travelId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCityId() {
		return this.cityId;
	}

	public void setPointLngLat(String pointLngLat) {
		this.pointLngLat = pointLngLat;
	}
	public String getPointLngLat() {
		return this.pointLngLat;
	}

	public void setPointType(Integer pointType) {
		this.pointType = pointType;
	}
	public Integer getPointType() {
		return this.pointType;
	}

	public void setPointDesc(String pointDesc) {
		this.pointDesc = pointDesc;
	}
	public String getPointDesc() {
		return this.pointDesc;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getCreateDate() {
		return this.createDate;
	}

}