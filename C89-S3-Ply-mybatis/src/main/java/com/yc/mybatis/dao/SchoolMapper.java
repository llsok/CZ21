package com.yc.mybatis.dao;

import java.util.List;

import com.yc.mybatis.bean.JsjSchool;

public interface SchoolMapper {
	
	public List<JsjSchool> selectByObj(JsjSchool school);

}
