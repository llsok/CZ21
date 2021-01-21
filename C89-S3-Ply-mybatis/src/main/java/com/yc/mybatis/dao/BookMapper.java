package com.yc.mybatis.dao;

import com.yc.mybatis.bean.JsjBook;

public interface BookMapper {
	
	/**
	 * 根据图书的id 查询图书
	 * @param id
	 * @return
	 */
	JsjBook selectById(int id);

}
