package com.yc.mvc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.yc.mvc.po.JsjCart;

public interface CartMapper {
	
	@Insert("insert into jsj_cart values(default, #{bid}, #{uid}, #{count}, default)")
	public int insert(JsjCart cart);
	
	@Update("update jsj_cart set count = count + #{count} where bid=#{bid} and uid=#{uid}")
	public int updateCount(JsjCart cart);

}
