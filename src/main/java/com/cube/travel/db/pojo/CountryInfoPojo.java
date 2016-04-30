package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.cube.framework.base.BasePojo;

@Table(name = "TravelMind.T_COUNTRY_INFO")
public class CountryInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public CountryInfoPojo() {}
	public CountryInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryName() {
		return this.countryName;
	}

}