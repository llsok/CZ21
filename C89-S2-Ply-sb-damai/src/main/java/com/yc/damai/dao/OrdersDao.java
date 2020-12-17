package com.yc.damai.dao;

import org.springframework.stereotype.Repository;

import com.yc.damai.po.Orders;

@Repository
public class OrdersDao extends BaseDao{

	/**
	 * 新增订单主表
	 * @param orders
	 */
	public void insertOrders(Orders orders) {
		String sql = "insert into orders values(null,?,now(),?,?,?,?,?)";
		jt.update(sql,
				orders.getTotal(),
				orders.getState(),
				orders.getAddr(),
				orders.getPhone(),
				orders.getUid(),
				orders.getName());
	}
	
	/**
	 * 新增订单明细
	 * @param orders
	 */
	public void insertItems(Orders orders) {
		String sql = "INSERT INTO orderitem SELECT\n" +
				"	NULL,\n" +
				"	a.count,\n" +
				"	a.count * b.shop_price,\n" +
				"	a.pid,\n" +
				"	LAST_INSERT_ID()\n" +
				"FROM\n" +
				"	cart a\n" +
				"JOIN product b ON a.pid = b.pid\n" +
				"WHERE\n" +
				"	a.uid = ?";
		jt.update(sql, orders.getUid());
	}
	

}
