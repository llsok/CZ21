package com.yc.damai.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDao {
	@Resource
	protected JdbcTemplate jt;
}
