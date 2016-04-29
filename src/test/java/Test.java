import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cube.framework.constants.Operator;
import com.cube.framework.utils.JSONUtils;
import com.cube.framework.utils.WhereFilter;
import com.cube.travel.user.service.BaseUserService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new FileSystemXmlApplicationContext(new String[]{"classpath:spring/spring-db.xml","classpath:spring/spring-biz.xml"});
		BaseUserService service = (BaseUserService)ac.getBean("baseUserService");
//		BaseUserPojo pojo = new BaseUserPojo();
//		pojo.setUserName("test1");
//		pojo.setUserPass("test1");
//		System.out.println(service.save(pojo));
//		pojo.setId(5);
//		pojo.setUserUuid("zxcvcvzxcvx");
//		System.out.println(service.editById(pojo));
//		System.out.println(service.removeById(2));
//		Integer result = dao.insert(pojo);
//		System.out.println(result);
//		pojo.setId(1);
//		pojo.setUserName("test1");
//		pojo.setUserPass("test1");
//		Integer result = dao.updateById(pojo);
//		System.out.println(result);
//		List<Map<String, Object>> list = dao.selectById(pojo);
		List<WhereFilter> filterList = new ArrayList<WhereFilter>();
		filterList.add(new WhereFilter("userName",Operator.LIKE_R,"test"));
		System.out.println(JSONUtils.listToJson(service.getAll(filterList)).toString());
//		System.out.println(new JSONObject(service.getByPage(filterList, 1, 5)).toString());
//		service.testAOP("123321");
	}

}
