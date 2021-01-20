package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.mvc.po.JsjUser;

public interface UserMapper {

	@Insert("insert into jsj_user (account,phone,name,pwd,email,gender) values"
			+ " (#{account},#{phone},#{name},#{pwd},#{email},#{gender})")
	int insert(JsjUser user);

	@Select("select * from jsj_user where account = #{account} and pwd = #{pwd}")
	JsjUser selectByAccountAndPwd(@Param("account") String account, @Param("pwd") String pwd);

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

	@Select("select * from jsj_user where id=#{id}")
	@Results(id="rmuser", value = { @Result(column = "school", property = "schoolObj", 
	one = @One(select = "com.yc.mvc.dao.SchoolMapper.selectById")),
			@Result(column = "id",property = "fans",
			many = @Many(select = "selectFans")),
			@Result(column = "id",property = "guanzhu",
			many = @Many(select = "selectGuanzhu"))})
	public JsjUser selectById(int id);
	

	@Select("select * from jsj_fans where uid = #{uid}")
	public List<JsjUser> selectFans(int uid);
	
	@Select("select * from jsj_fans where fid = #{fid}")
	public List<JsjUser> selectGuanzhu(int fid);

	@Update("update jsj_user set sign=#{sign} where id=#{id}")
	void updateJsjUserSign(String sign,int id) ;
	
	@Update("update jsj_user set pwd=#{pwd} where id=#{id}")
	void updatePwd(String pwd, Integer id);

	

}
