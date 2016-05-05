package com.cube.travel.db.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.cube.framework.base.BasePojo;

@Table(name = "realgame.t_item_info")
public class ItemInfoPojo extends BasePojo {

	private static final long serialVersionUID = 1L;

	public ItemInfoPojo() {}
	public ItemInfoPojo(Integer id) {this.id = id;}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "ITEM_NAME")
	private String itemName;

	@Column(name = "ITEM_TYPE")
	private Integer itemType;

	@Column(name = "ITEM_DESC")
	private String itemDesc;

	@Column(name = "ITEM_STATE")
	private Integer itemState;

	@Column(name = "ITEM_TOTAL_COUNT")
	private Integer itemTotalCount;

	@Column(name = "ITEM_FREE_COUNT")
	private Integer itemFreeCount;

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemName() {
		return this.itemName;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	public Integer getItemType() {
		return this.itemType;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemState(Integer itemState) {
		this.itemState = itemState;
	}
	public Integer getItemState() {
		return this.itemState;
	}

	public void setItemTotalCount(Integer itemTotalCount) {
		this.itemTotalCount = itemTotalCount;
	}
	public Integer getItemTotalCount() {
		return this.itemTotalCount;
	}

	public void setItemFreeCount(Integer itemFreeCount) {
		this.itemFreeCount = itemFreeCount;
	}
	public Integer getItemFreeCount() {
		return this.itemFreeCount;
	}

}