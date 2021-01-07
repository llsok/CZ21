package com.yc.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.mybatis.bean.JsjSchool;

public interface SchoolMapper {
	
	public List<JsjSchool> selectByObj(JsjSchool school);
	
	public int update(JsjSchool school);
	
	public JsjSchool selectById(int id);
	
	/**
	 * 	根据flag 的值对 name进行筛选
	 * 	flag = 1 精确查询  name = ?
	 * 	flag = 2 模糊查询 name like ?
	 * 	flag = 3 空值查询  name is null   不能写成 name = null
	 * 	flag 其他值 非空查询  name is not null
	 * @param name
	 * @param flag
	 * @return
	 * 
	 * 	接口多参数场景下, 必须为每个参数命名, 在参数前使用 Param 注解定义名称
	 * 
	 */
	public List<JsjSchool> selectByNameAndFlag( @Param("name") String name, @Param("flag")int flag);
	
	/**
	 * MyBatis 认为 数组, 集合 也是属于多参数
	 * @param names
	 * @return
	 */
	public List<JsjSchool> selectInNames(@Param("names")String[] names, @Param("orderby")String abc);

}
