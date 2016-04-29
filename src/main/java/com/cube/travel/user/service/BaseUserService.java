package com.cube.travel.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cube.framework.annotation.Log;
import com.cube.framework.base.BaseMapper;
import com.cube.framework.base.BaseService;
import com.cube.travel.db.dao.BaseUserDao;
import com.cube.travel.db.pojo.BaseUserPojo;

@Service
public class BaseUserService extends BaseService<BaseUserPojo> {
	
	private static Logger logger = LogManager.getLogger(BaseUserService.class);
	
	@Autowired
	private BaseUserDao dao;
	
	@Log
	public String testAOP(String param) {
		logger.info("testAOP() 方法体");
		return "testAOP() 返回结果";
	}

	@Override
	public BaseMapper<BaseUserPojo> getBaseMapper() {
		return this.dao;
	}

	@Override
	public BaseUserPojo getEntity(Object id) {
		return new BaseUserPojo((Integer)id);
	}

}
