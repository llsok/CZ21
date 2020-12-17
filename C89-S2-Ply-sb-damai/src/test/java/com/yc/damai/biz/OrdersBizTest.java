package com.yc.damai.biz;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.damai.po.Orders;
import com.yc.damai.po.Product;
import com.yc.damai.web.ProductAction;

@SpringBootTest
public class OrdersBizTest {

	@Resource
	private OrdersBiz obiz;
	
	@Test
	public void test1() {
		Orders o = new Orders();		
		o.setAddr("衡阳");
		o.setPhone("13800000111");
		o.setName("zhangsan");
		o.setUid(13);
		try {
			obiz.pay(o);
		} catch (BizException e) {
			e.printStackTrace();
		}
		
	}
	
	@Resource
	private ProductAction paction;
	
	@Test
	public void test2() {
		Product p = new Product();
		p.setPname("最新男款冬装");
		p.setMarketPrice(500d);
		p.setShopPrice(128d);
		p.setImage("products/1/cs10008.jpg");
		p.setCsid(1);
		paction.create(p);
	}
	
}
