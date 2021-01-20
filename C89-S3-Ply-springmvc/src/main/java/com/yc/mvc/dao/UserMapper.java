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

import com.yc.mvc.po.JsjFans;
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
	

	@Update("update jsj_user set collect_type=#{collectType},"
			+ "collect_account=#{collectAccount},collect_name=#{collectName} "
			+ "where id=#{id}")
	void addcollect(JsjUser user);


	@Select("select * from jsj_fans a left JOIN jsj_user b on a.fid = b.id where uid = #{uid}")
	@Results(id = "rmschool",value = { @Result(column = "school", property = "schoolObj", 
	one = @One(select = "com.yc.mvc.dao.SchoolMapper.selectById"))})
	public List<JsjUser> selectFans(int uid);
	
	@Select("select * from jsj_fans a left JOIN jsj_user b on a.uid = b.id where fid = #{fid}")
	@ResultMap("rmschool")
	public List<JsjUser> selectGuanzhu(int fid);

	@Update("update jsj_user set sign=#{sign} where id=#{id}")
	void updateJsjUserSign(String sign,int id) ;
	
	@Update("update jsj_user set pwd=#{pwd} where id=#{id}")
	void updatePwd(String pwd, Integer id);

	
	
//	@Select("select * from jsj_fans GROUP BY uid ORDER BY count(*) desc LIMIT 0,24")
//	@Results(value = { @Result(column = "uid", property = "user", 
//	one = @One(select = "selectById"))})
	@Select("select * from jsj_user b right JOIN jsj_fans a on a.uid = b.id "
			+ " GROUP BY a.uid ORDER BY count(*) desc LIMIT 0,24 ")
	@ResultMap("rmschool")
	public List<JsjUser> selectMostGuanZhu();
}
