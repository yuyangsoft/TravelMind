package com.cube.framework.build.pojo;

import javax.persistence.Column;
import javax.persistence.Table;

import com.cube.framework.base.BasePojo;

@Table(name="information_schema.KEY_COLUMN_USAGE")
public class KeyColumnUsagePojo extends BasePojo  {

	private static final long serialVersionUID = 1L;
	
	@Column(name="TABLE_SCHEMA")
	private String tableSchema;
	@Column(name="TABLE_NAME")
	private String tableName;
	@Column(name="COLUMN_NAME")
	private String columnName;
	@Column(name="REFERENCED_TABLE_NAME")
	private String referencedTableName;
	@Column(name="REFERENCED_COLUMN_NAME")
	private String referencedColumnName;
	@Column(name="REFERENCED_TABLE_SCHEMA")
	private String referencedTableSchema;
	
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
	public String getReferencedTableName() {
		return referencedTableName;
	}
	public void setReferencedTableName(String referencedTableName) {
		this.referencedTableName = referencedTableName;
	}
	public String getReferencedColumnName() {
		return referencedColumnName;
	}
	public void setReferencedColumnName(String referencedColumnName) {
		this.referencedColumnName = referencedColumnName;
	}
	public String getReferencedTableSchema() {
		return referencedTableSchema;
	}
	public void setReferencedTableSchema(String referencedTableSchema) {
		this.referencedTableSchema = referencedTableSchema;
	}
	

}
