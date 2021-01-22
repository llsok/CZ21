package com.yc.mvc.dao;

import org.apache.ibatis.annotations.Insert;

import com.yc.mvc.po.JsjOrderDetail;

public interface OrderDetailMapper {
	
	@Insert("insert into jsj_order_detail values(null,#{oid},#{bid},#{count},#{price})")
	void insert(JsjOrderDetail od);

}
