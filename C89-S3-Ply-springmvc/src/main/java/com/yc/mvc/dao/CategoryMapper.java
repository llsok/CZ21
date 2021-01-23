package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.yc.mvc.po.JsjCategory;

public interface CategoryMapper {
	
	@Select("select * from jsj_category where id=#{id}")
	JsjCategory selectById(Integer id);
	
	@Select("select * from jsj_category where name=#{name}")
	JsjCategory selectByName(String name);
	
	@Select("select * from jsj_category")
	List<JsjCategory> selectAll();
	
	@Update("update jsj_category set name = #{name} where id = #{id}")
	int update(JsjCategory category);
	
	@Insert("insert into jsj_category values(null,#{name})")
	int insert(String name);
	
	@Delete("delete from jsj_category where id = #{id}")
	int delete(int id);
}
