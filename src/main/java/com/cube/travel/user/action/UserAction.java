package com.cube.travel.user.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cube.framework.base.BaseController;
import com.cube.framework.base.BaseService;
import com.cube.framework.utils.WhereFilter;
import com.cube.travel.db.pojo.UserInfoPojo;
import com.cube.travel.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserAction extends BaseController<UserInfoPojo> {
	
	private static Logger logger = LogManager.getLogger(UserAction.class);
	
	@Autowired
	private UserService userService;
	
	//http://localhost:8080/TravelMind/send/user/login?sc_EQ_userName=test&sc_EQ_userPass=test1
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String userLogin(HttpServletRequest request, HttpServletResponse response) {
		List<WhereFilter> filterList = RequestUtil.getParametersStartingWith(request, "sc");
		List<UserInfoPojo> userList = this.userService.getAll(filterList);
		return userList.toString();
	}

	@Override
	public BaseService<UserInfoPojo> getService() {
		return this.userService;
	}

}
