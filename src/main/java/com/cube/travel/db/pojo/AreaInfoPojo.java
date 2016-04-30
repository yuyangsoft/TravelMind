package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.cube.framework.base.BasePojo;

@Table(name = "TravelMind.T_AREA_INFO")
public class AreaInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public AreaInfoPojo() {}
	public AreaInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "AREA_NAME")
	private String areaName;

	@Column(name = "AREA_DESC")
	private String areaDesc;

	@Column(name = "AREA_TYPE")
	private Integer areaType;

	@Column(name = "COUNTRY_ID")
	private Integer countryId;

	@Column(name = "CITY_ID")
	private Integer cityId;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}
	public String getAreaDesc() {
		return this.areaDesc;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}
	public Integer getAreaType() {
		return this.areaType;
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

}