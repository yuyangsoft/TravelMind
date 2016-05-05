package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.cube.framework.base.BasePojo;

@Table(name = "realgame.t_user_detail")
public class UserDetailPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public UserDetailPojo() {}
	public UserDetailPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "NICK_NAME")
	private String nickName;

	@Column(name = "SEX")
	private Integer sex;

	@Column(name = "OCCUPATION")
	private String occupation;

	@Column(name = "HOBBY")
	private String hobby;

	@Column(name = "QQ_NO")
	private String qqNo;

	@Column(name = "WECHAT_NO")
	private String wechatNo;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE_NO")
	private String phoneNo;

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

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getNickName() {
		return this.nickName;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getSex() {
		return this.sex;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getOccupation() {
		return this.occupation;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getHobby() {
		return this.hobby;
	}

	public void setQqNo(String qqNo) {
		this.qqNo = qqNo;
	}
	public String getQqNo() {
		return this.qqNo;
	}

	public void setWechatNo(String wechatNo) {
		this.wechatNo = wechatNo;
	}
	public String getWechatNo() {
		return this.wechatNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPhoneNo() {
		return this.phoneNo;
	}

}