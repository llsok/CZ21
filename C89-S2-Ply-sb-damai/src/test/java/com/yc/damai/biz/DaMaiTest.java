package com.yc.damai.biz;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;

import com.yc.damai.po.Orders;
import com.yc.damai.po.Product;
import com.yc.damai.web.ProductAction;

@SpringBootTest
public class DaMaiTest {

	@Resource
	private OrdersBiz obiz;
	
	@Test
	public void test1() {
		Orders o = new Orders();		
		o.setAddr("衡阳");
		o.setPhone("13800000111");
		o.setName("zhangsan");
		o.setUid(1);
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
	
	
	@Resource
	private StringRedisTemplate srt;
	@Test
	public void test3() {
		paction.queryProductById(1);
		paction.queryProductById(1);
		paction.queryProductById(1);
		paction.queryProductById(2);
		paction.queryProductById(2);
		paction.queryProductById(3);
		paction.queryProductById(3);
		String pb1 = srt.opsForValue().get("product_bcount_1");
		String pb2 = srt.opsForValue().get("product_bcount_2");
		String pb3 = srt.opsForValue().get("product_bcount_3");
		Assert.isTrue("3".equals(pb1),"数量为3!");
		Assert.isTrue("2".equals(pb2),"数量为2!");
		Assert.isTrue("2".equals(pb3),"数量为2!");
	}
	
}
