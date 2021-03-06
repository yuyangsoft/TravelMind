package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Timestamp;

import com.cube.framework.base.BasePojo;

@Table(name = "realgame.t_sys_log_info")
public class SysLogInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public SysLogInfoPojo() {}
	public SysLogInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "LOG_CONTENT")
	private String logContent;

	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	public String getLogContent() {
		return this.logContent;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getCreateDate() {
		return this.createDate;
	}

}