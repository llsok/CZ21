package com.yc.damai.biz;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.damai.po.Orders;

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
	
}
