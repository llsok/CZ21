package com.yc.favorite.dao;

import java.util.List;

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

	@Select("select * from favorite")
	List<Favorite> selectAll();
	
	@Select("  select a.* from favorite a"
			+ "  join tagfavorite b on a.fid=b.fid"
			+ " where b.tid=#{tid}")
	List<Favorite> selectByTid(int tid);

	@Select("select * from favorite a"
			+ " where not exists ( select * from tagfavorite b where a.fid=b.fid )")
	List<Favorite> selectNotTag();
	
	/**
	 * 	业务类中需要的方法， 请大家自行扩展
	 */

}
