package com.yc.favorite.dao;

import org.apache.ibatis.annotations.Insert;

import com.yc.favorite.bean.Favorite;

public interface FavoriteMapper {
	
	@Insert("????")
	int insert(Favorite f);

	Favorite selectByLabel(String string);
	
	/**
	 * 	业务类中需要的方法， 请大家自行扩展
	 */

}
