package com.cube.framework.build;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cube.framework.build.dao.ColumnsDao;
import com.cube.framework.build.dao.KeyColumnUsageDao;
import com.cube.framework.build.dao.TablesDao;
import com.cube.framework.build.pojo.ColumnsPojo;
import com.cube.framework.build.pojo.TablesPojo;
import com.cube.framework.constants.Operator;
import com.cube.framework.utils.WhereFilter;

public class BuildTablePojo {

	// 不在生成范围内的表名称规则，如：以_bak结尾的表、以tmp_开头的表 ******暂未实现，目前为表名中包含_bak或tmp_的表都不会生成
	private static final String[] NOT_BUILD_TABLE_NAME_RULE = { "_bak", "tmp_" };
	// 生成类名称的生成规则，如：表名为T_BASE_USER，生成的类名为BaseUserPojo和BaseUserDao
	private static final String BUILD_CLASS_NAME_RULE = "T_*";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String databaseName = "realgame";
		// String pojoPath =
		// "/Users/YuYang/work/WorkSpace/TravelMind/src/main/java/com/cube/travel/db/pojo/";
		// String daoPath =
		// "/Users/YuYang/work/WorkSpace/TravelMind/src/main/java/com/cube/travel/db/dao/";
		// 类文件存放在哪个物理文件夹下
		String pojoPath = "E:\\GitHub\\TravelMind\\src\\main\\java\\com\\cube\\travel\\db\\pojo\\";
		String daoPath = "E:\\GitHub\\TravelMind\\src\\main\\java\\com\\cube\\travel\\db\\dao\\";
		String servicePath = "E:\\GitHub\\TravelMind\\src\\main\\resources\\mybatis\\";
		// 类所属包路径
		String pojoPackagePath = "com.cube.travel.db.pojo";
		String daoPackagePath = "com.cube.travel.db.dao";
		String servicePackagePath = "com.cube.travel.user.service";
		BuildTablePojo build = new BuildTablePojo();
		build.build(databaseName, pojoPath, daoPath, servicePath, pojoPackagePath, daoPackagePath, servicePackagePath);
	}
	
	public void build(String databaseName, String pojoPath, String daoPath, String servicePath, String pojoPackagePath, String daoPackagePath, String servicePackagePath) {
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/spring-db.xml");
		System.out.println("自动生成Pojo、Dao、Mapper 开始 ...");
		ColumnsDao cdao = (ColumnsDao) ac.getBean("columnsDao");
		TablesDao tdao = (TablesDao) ac.getBean("tablesDao");
		KeyColumnUsageDao kdao = (KeyColumnUsageDao) ac.getBean("keyColumnUsageDao");
		List<WhereFilter> filterList = new ArrayList<WhereFilter>();
		filterList.add(new WhereFilter("tableSchema", Operator.eq, databaseName));
		List<Map<String, Object>> tlist = tdao.selectAll(new TablesPojo(), filterList);
		System.out.println("数据库" + databaseName + "中共有 " + tlist.size() + " 表!");
		for (int i = 0; i < tlist.size(); i++) {
			Map<String, Object> tmap = tlist.get(i);
			String tableName = (String) tmap.get("tableName");
			System.out.println("第" + (i + 1) + "个表：" + tableName + " 开始生成 ...");
			if (this.checkTableName((String) tmap.get("tableName"))) {
				System.out.println("第" + (i + 1) + "个表：" + tableName + " 名字中包含不生成字符串，所以跳过 ...");
				continue;
			}
			String pojoClassName = this.tableNameToClassName(tableName) + "Pojo";
			String daoClassName = this.tableNameToClassName(tableName) + "Dao";
			System.out.println("Pojo名为：" + pojoClassName);
			System.out.println("Dao名为：" + daoClassName);
			filterList.clear();
			filterList.add(new WhereFilter("tableSchema", Operator.eq, databaseName));
			filterList.add(new WhereFilter("tableName", Operator.eq, tableName));
			List<Map<String, Object>> columnsList = cdao.selectAll(new ColumnsPojo(), filterList);
			
			this.buildPojo(databaseName, tableName, pojoPath, pojoClassName, pojoPackagePath, columnsList);
			
			this.buildDao(databaseName, tableName, daoPath, daoClassName, pojoClassName, pojoPackagePath, daoPackagePath, columnsList, kdao, cdao);
			
			System.out.println("第" + (i + 1) + "个表：" + tableName + " 生成完成 ...");
		}
		System.out.println("自动生成Pojo、Dao、Mapper 完成 ...");
	}
	
	public void buildService() {
		
	}
	
	public void buildDao(String databaseName, String tableName, String daoPath, String daoClassName, String pojoClassName, String pojoPackagePath, String daoPackagePath, List<Map<String, Object>> columnsList, KeyColumnUsageDao kdao, ColumnsDao cdao) {
		File daoJavaFile = new File(daoPath + daoClassName + ".java");
		StringBuffer daosb = new StringBuffer();
		try {
			if (daoJavaFile.exists()) {
				return;
			}
			daoJavaFile.createNewFile();
//			StringBuffer importsb = new StringBuffer();
//			StringBuffer methodsb = new StringBuffer();
//			for (Map<String, Object> cmap : columnsList) {
//				String columnName = (String)cmap.get("columnName");
//				String columnKey = (String)cmap.get("columnKey");
//				if(columnKey != null && columnKey.equals("PRI")) {
//					List<WhereFilter> kFilterList = new ArrayList<WhereFilter>();
//					kFilterList.add(new WhereFilter("referencedTableSchema", Operator.EQ, databaseName));
//					kFilterList.add(new WhereFilter("referencedTableName", Operator.EQ, tableName));
//					kFilterList.add(new WhereFilter("referencedColumnName", Operator.EQ, columnName));
//					List<Map<String, Object>> klist = kdao.selectAll(new KeyColumnUsagePojo(), kFilterList);
//					if (klist != null && klist.size() > 0) {
//						for(Map<String, Object> km : klist) {
//							String rtableName = (String) km.get("tableName");
//							String rcolumnName = (String) km.get("columnName");
//							List<WhereFilter> cFilterList = new ArrayList<WhereFilter>();
//							cFilterList.add(new WhereFilter("tableSchema", Operator.EQ, databaseName));
//							cFilterList.add(new WhereFilter("tableName", Operator.EQ, rtableName));
//							cFilterList.add(new WhereFilter("columnName", Operator.EQ, rcolumnName));
//							List<Map<String, Object>> clist = cdao.selectAll(new ColumnsPojo(), cFilterList);
//							if(clist != null && clist.size() > 0) {
//								String rcDataType = (String)clist.get(0).get("dataType");
//								String rpojoClassName = this.tableNameToClassName(rtableName) + "Pojo";
//								if(importsb.indexOf("import " + pojoPackagePath + "." + rpojoClassName + ";") < 0) {
//									importsb.append("import " + pojoPackagePath + "." + rpojoClassName + ";\n");
//								}
//								if (importsb.indexOf("import java.util.List;") < 0) {
//									importsb.append("import java.util.List;\n");
//								}
//								methodsb.append("\tpublic List<" + rpojoClassName + "> select" + rpojoClassName + "ListByKey(" + this.getJavaDataType(rcDataType, importsb) + " key);\n\n");
//							}
//						}
//					}
//				} else if (columnKey != null && columnKey.equals("MUL")) {
//					List<WhereFilter> kFilterList = new ArrayList<WhereFilter>();
//					kFilterList.add(new WhereFilter("tableSchema", Operator.EQ, databaseName));
//					kFilterList.add(new WhereFilter("tableName", Operator.EQ, tableName));
//					kFilterList.add(new WhereFilter("columnName", Operator.EQ, columnName));
//					List<Map<String, Object>> klist = kdao.selectAll(new KeyColumnUsagePojo(), kFilterList);
//					if (klist != null && klist.size() > 0) {
//						String rtableName = (String) klist.get(0).get("referencedTableName");
//						String rcolumnName = (String) klist.get(0).get("referencedColumnName");
//						List<WhereFilter> cFilterList = new ArrayList<WhereFilter>();
//						cFilterList.add(new WhereFilter("tableSchema", Operator.EQ, databaseName));
//						cFilterList.add(new WhereFilter("tableName", Operator.EQ, rtableName));
//						cFilterList.add(new WhereFilter("columnName", Operator.EQ, rcolumnName));
//						List<Map<String, Object>> clist = cdao.selectAll(new ColumnsPojo(), cFilterList);
//						if(clist != null && clist.size() > 0) {
//							String rcDataType = (String)clist.get(0).get("dataType");
//							String rpojoClassName = this.tableNameToClassName(rtableName) + "Pojo";
//							if(importsb.indexOf("import " + pojoPackagePath + "." + rpojoClassName + ";") < 0) {
//								importsb.append("import " + pojoPackagePath + "." + rpojoClassName + ";\n");
//							}
//							methodsb.append("\tpublic " + rpojoClassName + " select" + rpojoClassName + "ByKey(" + this.getJavaDataType(rcDataType, importsb) + " key);\n\n");
//						}
//					}
//				}
//			}
			daosb.append("package " + daoPackagePath + ";\n\n");
			daosb.append("import com.cube.framework.base.BaseMapper;\n");
//			daosb.append(importsb);
			daosb.append("import " + pojoPackagePath + "." + pojoClassName + ";\n\n");
			daosb.append("public interface " + daoClassName + " extends BaseMapper<" + pojoClassName + "> {\n\n");
//			daosb.append(methodsb);
			daosb.append("}\n");
			FileOutputStream pojoout = new FileOutputStream(daoJavaFile, true);
			pojoout.write(daosb.toString().getBytes("utf-8"));
			pojoout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buildPojo(String databaseName, String tableName, String pojoPath, String pojoClassName, String pojoPackagePath, List<Map<String, Object>> columnsList) {
		File pojoJavaFile = new File(pojoPath + pojoClassName + ".java");
		StringBuffer pojosb = new StringBuffer();
		try {
			if (pojoJavaFile.exists()) {
				return;
			}
			pojoJavaFile.createNewFile();
			StringBuffer importsb = new StringBuffer();
			importsb.append("import javax.persistence.Id;\n");
			importsb.append("import javax.persistence.Table;\n");
			importsb.append("import javax.persistence.Column;\n\n");
			StringBuffer propertiessb = new StringBuffer();
			StringBuffer getsetsb = new StringBuffer();
			String priType = null;
			String priKey = null;
			for (Map<String, Object> cmap : columnsList) {
				String columnName = (String)cmap.get("columnName");
				String methodName = this.columnNameToGetSetName(columnName);
				String propertyName = this.columnNameToPropertyName(columnName);
				String dataType = this.getJavaDataType((String)cmap.get("dataType"), importsb);
				if (cmap.get("columnKey") != null && cmap.get("columnKey").equals("PRI")) {
					propertiessb.append("\t@Id\n");
					priType = dataType;
					priKey = propertyName;
				}
				propertiessb.append("\t@Column(name = \"" + columnName + "\")\n");
				propertiessb.append("\tprivate " + dataType + " " + propertyName + ";\n\n");
				getsetsb.append("\tpublic void set" + methodName + "(" + dataType + " " + propertyName + ") {\n");
				getsetsb.append("\t\tthis." + propertyName + " = " + propertyName + ";\n");
				getsetsb.append("\t}\n");
				getsetsb.append("\tpublic " + dataType + " get" + methodName + "() {\n");
				getsetsb.append("\t\treturn this." + propertyName + ";\n");
				getsetsb.append("\t}\n\n");
			}
			importsb.append("\nimport com.cube.framework.base.BasePojo;\n\n");
			pojosb.append("package " + pojoPackagePath + ";\n\n");
			pojosb.append(importsb);
			pojosb.append("@Table(name = \"" + databaseName + "." + tableName + "\")\n");
			pojosb.append("public class " + pojoClassName + " extends BasePojo {\n\n");
			pojosb.append("\tprivate static final long serialVersionUID = 1L;\n\n");
			pojosb.append("\tpublic " + pojoClassName + "() {}\n");
			if (priKey != null) {
				pojosb.append("\tpublic " + pojoClassName + "(" + priType + " " + priKey + ") {this." + priKey + " = " + priKey + ";}\n\n");
			}
			pojosb.append(propertiessb);
			pojosb.append(getsetsb);
			pojosb.append("}");
			FileOutputStream pojoout = new FileOutputStream(pojoJavaFile, true);
			pojoout.write(pojosb.toString().getBytes("utf-8"));
			pojoout.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private String getJavaDataType(String sqlDataType, StringBuffer importsb) {
		String dataType = "";
		if ("int".equals(sqlDataType)) {
			dataType = "Integer";
		} else if ("varchar".equals(sqlDataType)) {
			dataType = "String";
		} else if ("datetime".equals(sqlDataType)) {
			if (importsb.indexOf("import java.sql.Timestamp;") < 0) {
				importsb.append("import java.sql.Timestamp;\n");
			}
			dataType = "Timestamp";
		} else if ("bigint".equals(sqlDataType)) {
			dataType = "Long";
		} else if ("double".equals(sqlDataType)) {
			dataType = "Double";
		} else if ("decimal".equals(sqlDataType)) {
			dataType = "Long";
		} else if ("float".equals(sqlDataType)) {
			dataType = "Float";
		} else if ("date".equals(sqlDataType)) {
			if (importsb.indexOf("import java.sql.Date;") < 0) {
				importsb.append("import java.sql.Date;\n");
			}
			dataType = "Date";
		}
		return dataType;
	}

	private Boolean checkTableName(String tableName) {
		Boolean result = false;
		for (String str : NOT_BUILD_TABLE_NAME_RULE) {
			if (tableName.indexOf(str) > 0) {
				result = true;
			}
		}
		return result;
	}

	private String columnNameToGetSetName(String columnName) {
		String className = "";
		columnName = columnName.toLowerCase();
		String[] nameStr = columnName.split("_");
		for (String name : nameStr) {
			name = this.toUpperCaseFirstOne(name);
			className += name;
		}
		return className;
	}

	private String columnNameToPropertyName(String columnName) {
		String propertyName = "";
		columnName = columnName.toLowerCase();
		String[] nameStr = columnName.split("_");
		for (int i = 0; i < nameStr.length; i++) {
			String name = nameStr[i];
			if (i != 0) {
				name = this.toUpperCaseFirstOne(name);
			}
			propertyName += name;
		}
		return propertyName;
	}

	private String tableNameToClassName(String tableName) {
		String className = "";
		tableName = tableName.toLowerCase();
		String[] nameStr = tableName.split("_");
		for (String name : nameStr) {
			if (name.equals("t")) {
				continue;
			}
			name = this.toUpperCaseFirstOne(name);
			className += name;
		}
		return className;
	}

	private String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

}
