package com.cube.framework.build.pojo;

import javax.persistence.Column;
import javax.persistence.Table;

import com.cube.framework.base.BasePojo;

@Table(name="information_schema.COLUMNS")
public class ColumnsPojo extends BasePojo {

	private static final long serialVersionUID = 1L;
	@Column(name="TABLE_SCHEMA")
	private String tableSchema;
	@Column(name="TABLE_NAME")
	private String tableName;
	@Column(name="COLUMN_NAME")
	private String columnName;
	@Column(name="DATA_TYPE")
	private String dataType;
	@Column(name="COLUMN_KEY")
	private String columnKey;
	
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
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

}
