package com.yc.damai.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

//@Repository 删除该注解，BaseDao不需要IOC管理
// BaseDao 后期会继续扩展该类的方法
public abstract class BaseDao {
	
	@Resource
	protected JdbcTemplate jt;

}
