package com.yc.mvc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjUser;

public interface UserMapper {

	@Insert("insert into jsj_user (account,phone,name,pwd,email,gender) values"
			+ " (#{account},#{phone},#{name},#{pwd},#{email},#{gender})")
	int insert(JsjUser user);
	
	@Select("select * from jsj_user where account = #{account}")
	JsjUser selectByAccount(String account);
}
