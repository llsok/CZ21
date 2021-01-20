package com.yc.mvc.dao;

import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjSchool;

public interface SchoolMapper {
	
	@Select("select * from jsj_school where id=#{id}")
	public JsjSchool selectById(int id);
}
