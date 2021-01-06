package com.yc.mybatis.dao;

import com.yc.mybatis.bean.JsjUser;

public interface UserMapper {
	
	public JsjUser selectById(int id);

}
