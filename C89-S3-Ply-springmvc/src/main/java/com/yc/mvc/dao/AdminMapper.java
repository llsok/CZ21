package com.yc.mvc.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjAdmin;

public interface AdminMapper {

	@Select("select * from jsj_admin where account = #{account} and pwd = #{pwd}")
	JsjAdmin selectByAccountAndPwd(@Param("account") String account, @Param("pwd") String pwd);
}
