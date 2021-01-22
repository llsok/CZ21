package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjLink;

public interface LinkMapper {
	
	@Select("select * from jsj_link order by id")
	List<JsjLink> selectAll(); 
}
