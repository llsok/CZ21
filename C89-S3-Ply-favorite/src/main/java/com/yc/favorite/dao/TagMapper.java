package com.yc.favorite.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.favorite.bean.Tag;

public interface TagMapper {
	@Insert("insert into tag values (null, #{tname}, #{tcount})")
	@Options(useGeneratedKeys = true, keyColumn = "tid", keyProperty = "tid")
	int insert(Tag tag);
	
	/**
	 * 根据分类名，查询分类对象
	 * @param string
	 * @return
	 */
	@Select("select * from tag where tname=#{n}")
	Tag selectByName(String tname);
	
	@Update("update tag set tcount = tcount+1 where tname=#{tname}")
	int updateCountByName(String tag);
	
	
	

	/**
	 * 	业务类中需要的方法， 请大家自行扩展
	 */

}
