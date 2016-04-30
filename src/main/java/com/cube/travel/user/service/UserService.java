package com.cube.travel.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cube.framework.base.BaseMapper;
import com.cube.framework.base.BaseService;
import com.cube.travel.db.dao.UserInfoDao;
import com.cube.travel.db.pojo.UserInfoPojo;

@Service
public class UserService extends BaseService<UserInfoPojo> {
	
	private static Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private UserInfoDao dao;
	

	@Override
	public BaseMapper<UserInfoPojo> getBaseMapper() {
		return this.dao;
	}

	@Override
	public UserInfoPojo getEntity(Object id) {
		return new UserInfoPojo(Integer.parseInt((String)id));
	}

}
