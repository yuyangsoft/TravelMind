package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Timestamp;

import com.cube.framework.base.BasePojo;

@Table(name = "realgame.t_user_item")
public class UserItemPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public UserItemPojo() {}
	public UserItemPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "ITEM_ID")
	private Integer itemId;

	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	@Column(name = "GET_TYPE")
	private Integer getType;

	@Column(name = "GET_STATE")
	private Integer getState;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getItemId() {
		return this.itemId;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setGetType(Integer getType) {
		this.getType = getType;
	}
	public Integer getGetType() {
		return this.getType;
	}

	public void setGetState(Integer getState) {
		this.getState = getState;
	}
	public Integer getGetState() {
		return this.getState;
	}

}