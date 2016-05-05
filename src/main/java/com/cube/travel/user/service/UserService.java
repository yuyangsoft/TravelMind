package com.cube.travel.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cube.framework.base.BaseMapper;
import com.cube.framework.base.BaseService;
import com.cube.framework.utils.WhereFilter;
import com.cube.travel.db.dao.UserInfoDao;
import com.cube.travel.db.pojo.UserInfoPojo;

@Service
public class UserService extends BaseService<UserInfoPojo> {
	
	private static Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private UserInfoDao dao;
	
	public Map<String, Object> login(List<WhereFilter> filterList) {
		Map<String, Object> userInfo = new HashMap<String, Object>();
		List<UserInfoPojo> userList = super.getAll(filterList);
		if(userList == null || userList.size() <= 0) {
			logger.info("用户名或密码不正确！");
			return null;
		}
		userInfo.put("userInfo", userList.get(0));
		return userInfo;
	}
	
	@Override
	public BaseMapper<UserInfoPojo> getBaseMapper() {
		return this.dao;
	}

	@Override
	public UserInfoPojo getEntity(Object id) {
		if(id == null) {
			return new UserInfoPojo();
		} else {
			return new UserInfoPojo(Integer.parseInt((String)id));
		}
	}

}
