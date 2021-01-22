package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.yc.mvc.po.JsjCategory;

public interface CategoryMapper {
	
	@Select("select * from jsj_category where id=#{id}")
	JsjCategory selectById(Integer id);
	
	@Select("select * from jsj_category")
	List<JsjCategory> selectAll();
}
