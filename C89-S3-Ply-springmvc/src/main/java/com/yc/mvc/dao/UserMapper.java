package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.mvc.po.JsjUser;

public interface UserMapper {

	@Insert("insert into jsj_user (account,phone,name,pwd,email,gender) values"
			+ " (#{account},#{phone},#{name},#{pwd},#{email},#{gender})")
	int insert(JsjUser user);
	
	@Select("select * from jsj_user where account = #{account} and pwd = #{pwd}")
	JsjUser selectByAccountAndPwd(@Param("account")String account,@Param("pwd")String pwd);

	@Select("select *from jsj_user where account = #{account}")
	JsjUser selectByAccount(String account);

	@Update("update jsj_user set head_img=#{headImg} where id=#{id}")
	void updateHeadImg(JsjUser loginedUser);

	
	@Select("select * from jsj_user order by last_login_time desc limit 0,24")
	public List<JsjUser> getlastTimeUsers();


	@Update("update jsj_user set last_login_time=#{lastLoginTime} where id=#{id}")
	void updatelastLoginTime(JsjUser loginedUser);

	@Select("select * from jsj_user ORDER BY reg_time LIMIT 0,24")
	List<JsjUser> selectNewRegUser();
}
