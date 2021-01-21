package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.mvc.po.JsjCart;

public interface CartMapper {
	
	@Insert("insert into jsj_cart values(default, #{bid}, #{uid}, #{count}, default)")
	public int insert(JsjCart cart);
	
	@Update("update jsj_cart set count = count + #{count} where bid=#{bid} and uid=#{uid}")
	public int updateCount(JsjCart cart);

	@Select("select * from jsj_cart where uid=#{uid}")
	@Results(id="rmcart", value = { @Result(column = "bid", property = "book", 
		one = @One(select = "com.yc.mvc.dao.BooksMapper.quertBookDetail")) })
	public List<JsjCart> queryCartByUid(int uid);

	@Delete("delete from jsj_cart where bid = #{bid} and uid = #{uid}")
	public void delete(@Param("bid")Long bid, @Param("uid")Long uid);

}

