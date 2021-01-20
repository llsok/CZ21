package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjFans;
import com.yc.mvc.po.JsjUser;

public interface FanMapper {

	@Select("select * from jsj_user a join jsj_fans b on a.id=b.fid where uid=#{id}")
	@ResultMap("com.yc.mvc.dao.UserMapper.rmuser")
	List<JsjUser> queryFansById(JsjUser loginedUser);
	
}
