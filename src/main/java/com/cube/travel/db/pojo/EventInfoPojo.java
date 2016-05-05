package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Timestamp;

import com.cube.framework.base.BasePojo;

@Table(name = "realgame.t_event_info")
public class EventInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public EventInfoPojo() {}
	public EventInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "DESIGNER")
	private Integer designer;

	@Column(name = "EVENT_TYPE")
	private Integer eventType;

	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	@Column(name = "MESSAGE")
	private String message;

	@Column(name = "POINT")
	private String point;

	@Column(name = "TRIGGER_ID")
	private Integer triggerId;

	@Column(name = "TRIGGER_DATE")
	private Timestamp triggerDate;

	@Column(name = "REPLY")
	private String reply;

	@Column(name = "EFFECT")
	private String effect;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setDesigner(Integer designer) {
		this.designer = designer;
	}
	public Integer getDesigner() {
		return this.designer;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}
	public Integer getEventType() {
		return this.eventType;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}

	public void setPoint(String point) {
		this.point = point;
	}
	public String getPoint() {
		return this.point;
	}

	public void setTriggerId(Integer triggerId) {
		this.triggerId = triggerId;
	}
	public Integer getTriggerId() {
		return this.triggerId;
	}

	public void setTriggerDate(Timestamp triggerDate) {
		this.triggerDate = triggerDate;
	}
	public Timestamp getTriggerDate() {
		return this.triggerDate;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReply() {
		return this.reply;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getEffect() {
		return this.effect;
	}

}