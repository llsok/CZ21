package com.yc.mvc.dao;




import org.apache.ibatis.annotations.Insert;


import org.apache.ibatis.annotations.Options;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.mvc.po.JsjOrder;


public interface OrderMapper {

	@Insert("insert into jsj_order values(null, "
			+ "#{uid}, #{addrName}, #{addrPhone}, #{addrDesc}, "
			+ "#{money}, #{createTime}, 0, #{remark})")
	// useGeneratedKeys 获取数据库生产的主键值
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void insert(JsjOrder order);
    
	
	@Select("SELECT * FROM jsj_order WHERE id=#{id}")
    public JsjOrder selectSellOrders(Integer oid);

    @Update("update jsj_order_detail set state=2 where id=#{id}")
	void sendOrder(int id);
	
	
}

