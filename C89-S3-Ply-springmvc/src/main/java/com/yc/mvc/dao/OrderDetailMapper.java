package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjOrderDetail;

public interface OrderDetailMapper {
	
	@Insert("insert into jsj_order_detail values(null,#{oid},#{bid},#{count},#{price})")
	void insert(JsjOrderDetail od);
	
	@Select("select * from  jsj_order_detail a join jsj_book b on a.bid=b.id where b.owner_id=#{ownerId}")
	@Results(id="rmOrder", value = { 
			@Result(column = "oid",property = "sellOrders",
			one = @One(select = "com.yc.mvc.dao.OrderMapper.selectSellOrders")),
			@Result(column = "bid",property = "book",
			one = @One(select = "com.yc.mvc.dao.BooksMapper.quertBookDetail"))})
	public List<JsjOrderDetail> queryOrderByOwnId(Integer id);

}

