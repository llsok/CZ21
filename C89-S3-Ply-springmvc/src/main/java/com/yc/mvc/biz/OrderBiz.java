
package com.yc.mvc.biz;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.mvc.dao.CartMapper;
import com.yc.mvc.dao.OrderDetailMapper;
import com.yc.mvc.dao.OrderMapper;
import com.yc.mvc.po.JsjOrder;
import com.yc.mvc.po.JsjOrderDetail;

@Service
public class OrderBiz {

	@Resource
	private OrderMapper om;
	@Resource
	private OrderDetailMapper odm;
	@Resource
	private CartMapper cm;

	@Transactional
	public void addOrder(JsjOrder order) {
		/**
		 * 	计算 money 的值
		 * 	写入 order 表
		 * 	写入 orderdetail 表 ， 获取 order 主键值  mybatis 获取主键的配置
		 * 	删除购物已经被购买的商品
		 */
		// 计算 money 的值
		double sum = 0;
		for (JsjOrderDetail od : order.getDetails()) {
			double price = Double.parseDouble(od.getBook().getPrice());
			sum += od.getCount() * price;
			od.setPrice(price);
		}
		order.setMoney(sum);
		Date date=new Date();
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		Timestamp timestamp=Timestamp.valueOf(time);
        order.setCreateTime(timestamp);
		// 写入 order 表
		om.insert(order);

		for (JsjOrderDetail od : order.getDetails()) {
			od.setOid(order.getId()); // useGeneratedKeys = true  order.getId() 成立
	        odm.insert(od);
			cm.delete(od.getBid(), order.getUid());
		}

	}

}
