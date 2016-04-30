package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.cube.framework.base.BasePojo;

@Table(name = "TravelMind.T_CITY_INFO")
public class CityInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public CityInfoPojo() {}
	public CityInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "CITY_NAME")
	private String cityName;

	@Column(name = "COUNTRY_ID")
	private Integer countryId;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityName() {
		return this.cityName;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getCountryId() {
		return this.countryId;
	}

}