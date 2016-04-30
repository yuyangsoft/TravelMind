package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.cube.framework.base.BasePojo;

@Table(name = "TravelMind.T_FILE_INFO")
public class FileInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public FileInfoPojo() {}
	public FileInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "FILE_PATH")
	private String filePath;

	@Column(name = "FILE_TYPE")
	private Integer fileType;

	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "POINT_ID")
	private Integer pointId;

	@Column(name = "AREA_ID")
	private Integer areaId;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFilePath() {
		return this.filePath;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	public Integer getFileType() {
		return this.fileType;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}
	public Integer getPointId() {
		return this.pointId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getAreaId() {
		return this.areaId;
	}

}