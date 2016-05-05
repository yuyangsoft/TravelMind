package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.cube.framework.base.BasePojo;

@Table(name = "realgame.t_sys_config")
public class SysConfigPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public SysConfigPojo() {}
	public SysConfigPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "CFG_NAME")
	private String cfgName;

	@Column(name = "CFG_CODE")
	private String cfgCode;

	@Column(name = "CFG_DESC")
	private String cfgDesc;

	@Column(name = "CFG_VALUE")
	private String cfgValue;

	@Column(name = "CFG_STATE")
	private Integer cfgState;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setCfgName(String cfgName) {
		this.cfgName = cfgName;
	}
	public String getCfgName() {
		return this.cfgName;
	}

	public void setCfgCode(String cfgCode) {
		this.cfgCode = cfgCode;
	}
	public String getCfgCode() {
		return this.cfgCode;
	}

	public void setCfgDesc(String cfgDesc) {
		this.cfgDesc = cfgDesc;
	}
	public String getCfgDesc() {
		return this.cfgDesc;
	}

	public void setCfgValue(String cfgValue) {
		this.cfgValue = cfgValue;
	}
	public String getCfgValue() {
		return this.cfgValue;
	}

	public void setCfgState(Integer cfgState) {
		this.cfgState = cfgState;
	}
	public Integer getCfgState() {
		return this.cfgState;
	}

}