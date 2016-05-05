package com.cube.travel.user.action;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cube.framework.base.BaseController;
import com.cube.framework.base.BaseService;
import com.cube.framework.utils.WebResultInfo;
import com.cube.framework.utils.WhereFilter;
import com.cube.travel.db.pojo.UserInfoPojo;
import com.cube.travel.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserAction extends BaseController<UserInfoPojo> {
	
	private static Logger logger = LogManager.getLogger(UserAction.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录
	 * @param paramJson 请求参数：{"eq_loginName":"test1","eq_loginPass":"test1"}
	 * @return
	 */
	@RequestMapping(value="/login")
	public String userLogin(@RequestBody JSONObject paramJson) {
		WebResultInfo resultInfo = new WebResultInfo();
		List<WhereFilter> filterList = RequestUtil.getParametersStartingWith(paramJson);
		List<UserInfoPojo> userList = this.userService.getAll(filterList);
		logger.debug(userList.toString());
		return userList.toString();
	}

	@Override
	public BaseService<UserInfoPojo> getService() {
		return this.userService;
	}

}
