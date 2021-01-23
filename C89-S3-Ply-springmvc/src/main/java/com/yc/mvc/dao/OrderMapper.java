package com.yc.mvc.dao;




import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.mvc.po.JsjOrder;
import com.yc.mvc.po.JsjOrderDetail;


public interface OrderMapper {

	@Insert("insert into jsj_order values(null, "
			+ "#{uid}, #{addrName}, #{addrPhone}, #{addrDesc}, "
			+ "#{money}, #{createTime}, 0, #{remark})")
	// useGeneratedKeys 获取数据库生产的主键值
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void insert(JsjOrder order);
    
	
	@Select("SELECT * FROM jsj_order WHERE id=#{id}")
    public JsjOrder selectSellOrders(Integer oid);


	@Select("select * from jsj_order o join jsj_order_detail b on o.id=b.oid where o.uid=#{id}")
    @ResultMap("com.yc.mvc.dao.OrderDetailMapper.rmOrder")
	List<JsjOrder> queryOrderListByUid(Integer id);
	
    @Update("update jsj_order_detail set state=2 where id=#{id}")
	void sendOrder(int id);
	
    @Select("select * from jsj_order where id=#{id}")
	public JsjOrder queryOrderById(Integer id);
    
    @Select("SELECT * from jsj_order where id =(select MAX(id) from jsj_order)")
	public JsjOrder queryNewOrder();
}

