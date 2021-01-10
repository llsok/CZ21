package com.yc.favorite.dao;

import org.apache.ibatis.annotations.Insert;

import com.yc.favorite.bean.Tag;

public interface TagMapper {
	
	@Insert("insert into tag values (null, #{tname}, #{tcount})")
	int insert(Tag tag);

	/**
	 * 根据分类名，查询分类对象
	 * @param string
	 * @return
	 */
	Tag selectByName(String string);
	
	/**
	 * 	业务类中需要的方法， 请大家自行扩展
	 */


}
