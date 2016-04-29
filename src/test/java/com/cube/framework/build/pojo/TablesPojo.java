package com.cube.framework.build.pojo;

import javax.persistence.Column;
import javax.persistence.Table;

import com.cube.framework.base.BasePojo;

@Table(name="information_schema.TABLES")
public class TablesPojo extends BasePojo {

	private static final long serialVersionUID = 1L;
	@Column(name="TABLE_SCHEMA")
	private String tableSchema;
	@Column(name="TABLE_NAME")
	private String tableName;
	public String getTableSchema() {
		return tableSchema;
	}
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
