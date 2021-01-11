package com.yc.favorite.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.yc.favorite.bean.Favorite;

public interface FavoriteMapper {
	
	@Insert("insert into favorite values (null, #{flabel}, #{furl}, #{fdesc}, #{ftags})")
	@Options(useGeneratedKeys = true, keyColumn = "fid", keyProperty = "fid")
	int insert(Favorite f);

	@Select("select * from favorite where flabel=#{l}")
	Favorite selectByLabel(String flabel);
	
	/**
	 * 	业务类中需要的方法， 请大家自行扩展
	 */

}
