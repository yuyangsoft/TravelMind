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
import com.cube.framework.build.pojo.KeyColumnUsagePojo;
import com.cube.framework.build.pojo.TablesPojo;
import com.cube.framework.constants.Operator;
import com.cube.framework.utils.WhereFilter;

public class BuildTablePojo {
	
	//不在生成范围内的表名称规则，如：以_bak结尾的表、以tmp_开头的表   ******暂未实现，目前为表名中包含_bak或tmp_的表都不会生成
	private static final String[] NOT_BUILD_TABLE_NAME_RULE = {"_bak","tmp_"};
	//生成类名称的生成规则，如：表名为T_BASE_USER，生成的类名为BaseUserPojo和BaseUserDao
	private static final String BUILD_CLASS_NAME_RULE = "T_*";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String databaseName = "TravelMind";
		String pojoPath = "/Users/YuYang/work/WorkSpace/TravelMind/src/main/java/com/cube/travel/db/pojo/";
		String daoPath = "/Users/YuYang/work/WorkSpace/TravelMind/src/main/java/com/cube/travel/db/dao/";
		//类文件存放在哪个物理文件夹下
//		String pojoPath = "E:\\Work\\TravelMind\\src\\main\\java\\com\\cube\\travel\\db\\pojo\\";
//		String daoPath = "E:\\Work\\TravelMind\\src\\main\\java\\com\\cube\\travel\\db\\dao\\";
		//类所属包路径
		String pojoPackagePath = "com.cube.travel.db.pojo";
		String daoPackagePath = "com.cube.travel.db.dao";
		BuildTablePojo build = new BuildTablePojo();
		build.build(databaseName, pojoPath, daoPath,pojoPackagePath,daoPackagePath);
	}
	
	public void build(String databaseName,String pojoPath,String daoPaht,String pojoPackagePath,String daoPackagePath) {
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/spring-db.xml");
		System.out.println("自动生成POJO和DAO 开始 ...");
		ColumnsDao cdao = (ColumnsDao)ac.getBean("columnsDao");
		TablesDao tdao = (TablesDao)ac.getBean("tablesDao");
		KeyColumnUsageDao kdao = (KeyColumnUsageDao)ac.getBean("keyColumnUsageDao");
		List<WhereFilter> filterList = new ArrayList<WhereFilter>();
		filterList.add(new WhereFilter("tableSchema",Operator.EQ,databaseName));
		List<Map<String, Object>> tlist = tdao.selectAll(new TablesPojo(), filterList);
		System.out.println("数据库" + databaseName + "中共有 " + tlist.size() + " 表!");
		for(int i = 0; i < tlist.size(); i++) {
			Map<String, Object> tmap = tlist.get(i);
			System.out.println("第" + (i + 1) + "个表：" + tmap.get("tableName") + " 开始生成 ...");
			if(this.checkTableName((String)tmap.get("tableName"))) {
				System.out.println("第" + (i + 1) + "个表：" + tmap.get("tableName") + " 名字中包含不生成字符串，所以跳过 ...");
				continue;
			}
			String pojoClassName = this.tableNameToClassName((String)tmap.get("tableName")) + "Pojo";
			String daoClassName = this.tableNameToClassName((String)tmap.get("tableName")) + "Dao";
			System.out.println("POJO名为：" + pojoClassName);
			System.out.println("DAO名为：" + daoClassName);
			File pojoJavaFile = new File(pojoPath + pojoClassName + ".java");
			StringBuffer pojosb = new StringBuffer();
			try {
				if(pojoJavaFile.exists()) {
					pojoJavaFile.delete();
				}
				pojoJavaFile.createNewFile();
				StringBuffer importsb = new StringBuffer();
				importsb.append("import javax.persistence.Id;\n");
				importsb.append("import javax.persistence.Table;\n");
				importsb.append("import javax.persistence.Column;\n\n");
				StringBuffer propertiessb = new StringBuffer();
				StringBuffer getsetsb = new StringBuffer();
				filterList.clear();
				filterList.add(new WhereFilter("tableSchema",Operator.EQ,databaseName));
				filterList.add(new WhereFilter("tableName",Operator.EQ,tmap.get("tableName")));
				List<Map<String, Object>> clist = cdao.selectAll(new ColumnsPojo(), filterList);
				String priType = null;
				String priKey = null;
				for(Map<String, Object> cmap : clist) {
					String dataType = "";
					if("int".equals(cmap.get("dataType"))) {
						dataType = "Integer";
					} else if("varchar".equals(cmap.get("dataType"))) {
						dataType = "String";
					} else if("datetime".equals(cmap.get("dataType"))) {
						importsb.append("import java.sql.Timestamp;\n");
						dataType = "Timestamp";
					} else if("bigint".equals(cmap.get("dataType"))) {
						dataType = "Long";
					} else if("double".equals(cmap.get("dataType"))) {
						dataType = "Double";
					} else if("decimal".equals(cmap.get("dataType"))) {
						dataType = "Long";
					} else if("float".equals(cmap.get("dataType"))) {
						dataType = "Float";
					}
					if(cmap.get("columnKey") != null && cmap.get("columnKey").equals("PRI")) {
						propertiessb.append("\t@Id\n");
						priType = dataType;
						priKey = this.columnNameToPropertyName((String)cmap.get("columnName"));
						List<WhereFilter> kFilterList = new ArrayList<WhereFilter>();
						kFilterList.add(new WhereFilter("referencedTableSchema",Operator.EQ,databaseName));
						kFilterList.add(new WhereFilter("referencedTableName",Operator.EQ,tmap.get("tableName")));
						kFilterList.add(new WhereFilter("referencedColumnName",Operator.EQ,cmap.get("columnName")));
						List<Map<String, Object>> klist = kdao.selectAll(new KeyColumnUsagePojo(), kFilterList);
						if(klist != null && klist.size() > 0) {
							if(importsb.indexOf("import javax.persistence.OneToMany;") < 0) {
								importsb.append("import javax.persistence.OneToMany;\n");
							}
							String rtableName = (String)klist.get(0).get("tableName");
							propertiessb.append("\t@OneToMany(targetEntity = " + this.tableNameToClassName(rtableName) + "Pojo.class)\n");
						}
					} else if(cmap.get("columnKey") != null && cmap.get("columnKey").equals("MUL")) {
						List<WhereFilter> kFilterList = new ArrayList<WhereFilter>();
						kFilterList.add(new WhereFilter("tableSchema",Operator.EQ,databaseName));
						kFilterList.add(new WhereFilter("tableName",Operator.EQ,tmap.get("tableName")));
						kFilterList.add(new WhereFilter("columnName",Operator.EQ,cmap.get("columnName")));
						List<Map<String, Object>> klist = kdao.selectAll(new KeyColumnUsagePojo(), kFilterList);
						if(klist != null && klist.size() > 0) {
							if(importsb.indexOf("import javax.persistence.ManyToOne;") < 0) {
								importsb.append("import javax.persistence.ManyToOne;\n");
							}
							String rtableName = (String)klist.get(0).get("referencedTableName");
							propertiessb.append("\t@ManyToOne(targetEntity = " + this.tableNameToClassName(rtableName) + "Pojo.class)\n");
						}
					}
					propertiessb.append("\t@Column(name = \"" + cmap.get("columnName") + "\")\n");
					propertiessb.append("\tprivate " + dataType + " " + this.columnNameToPropertyName((String)cmap.get("columnName")) + ";\n\n");
					getsetsb.append("\tpublic void set" + this.columnNameToGetSetName((String)cmap.get("columnName")) + "(" + dataType + " " + this.columnNameToPropertyName((String)cmap.get("columnName")) + ") {\n");
					getsetsb.append("\t\tthis." + this.columnNameToPropertyName((String)cmap.get("columnName")) + " = " + this.columnNameToPropertyName((String)cmap.get("columnName")) + ";\n");
					getsetsb.append("\t}\n");
					getsetsb.append("\tpublic " + dataType + " get" + this.columnNameToGetSetName((String)cmap.get("columnName")) + "() {\n");
					getsetsb.append("\t\treturn this." + this.columnNameToPropertyName((String)cmap.get("columnName")) + ";\n");
					getsetsb.append("\t}\n\n");
				}
				importsb.append("\nimport com.cube.framework.base.BasePojo;\n\n");
				pojosb.append("package " + pojoPackagePath + ";\n\n");
				pojosb.append(importsb );
				pojosb.append("@Table(name = \"" + databaseName + "." + tmap.get("tableName") + "\")\n");
				pojosb.append("public class " + pojoClassName + " extends BasePojo {\n\n");
				pojosb.append("\tprivate static final long serialVersionUID = 1L;\n\n");
				pojosb.append("\tpublic " + pojoClassName + "() {}\n");
				if(priKey != null) {
					pojosb.append("\tpublic " + pojoClassName + "(" + priType + " " + priKey + ") {this." + priKey + " = " + priKey + ";}\n\n");
				}
				pojosb.append(propertiessb);
				pojosb.append(getsetsb);
				pojosb.append("}");
				FileOutputStream pojoout=new FileOutputStream(pojoJavaFile,true);
				pojoout.write(pojosb.toString().getBytes("utf-8"));
				pojoout.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			File daoJavaFile = new File(daoPaht + this.tableNameToClassName((String)tmap.get("tableName")) + "Dao.java");
			StringBuffer daosb = new StringBuffer();
			try {
				if(daoJavaFile.exists()) {
					daoJavaFile.delete();
				}
				daoJavaFile.createNewFile();
				daosb.append("package " + daoPackagePath + ";\n\n");
				daosb.append("import com.cube.framework.base.BaseMapper;\n");
				daosb.append("import " + pojoPackagePath + "." + pojoClassName + ";\n\n");
				daosb.append("public interface " + daoClassName + " extends BaseMapper<" + pojoClassName + "> {\n\n");
				daosb.append("}\n");
				FileOutputStream pojoout=new FileOutputStream(daoJavaFile,true);
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
			System.out.println("第" + (i + 1) + "套 生成完成 ...");
		}
		System.out.println("自动生成POJO和DAO 完成 ...");
	}
	
	private Boolean checkTableName(String tableName) {
		Boolean result = false;
		for(String str : NOT_BUILD_TABLE_NAME_RULE) {
			if(tableName.indexOf(str) > 0) {
				result = true;
			}
		}
		return result;
	}
	
	private String columnNameToGetSetName(String columnName) {
		String className = "";
		columnName = columnName.toLowerCase();
		String[] nameStr = columnName.split("_");
		for(String name : nameStr) {
			name = this.toUpperCaseFirstOne(name);
			className += name;
		}
		return className;
	}
	
	private String columnNameToPropertyName(String columnName) {
		String propertyName = "";
		columnName = columnName.toLowerCase();
		String[] nameStr = columnName.split("_");
		for(int i = 0; i < nameStr.length; i++) {
			String name = nameStr[i];
			if(i != 0) {
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
		for(String name : nameStr) {
			if(name.equals("t")) {
				continue;
			}
			name = this.toUpperCaseFirstOne(name);
			className += name;
		}
		return className;
	}
	
	private String toUpperCaseFirstOne(String s)
    {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
