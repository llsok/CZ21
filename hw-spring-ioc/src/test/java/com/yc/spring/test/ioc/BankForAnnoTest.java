package com.yc.spring.test.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yc.spring.bank.BankConfig;
import com.yc.spring.bank.biz.AccountBiz;
import com.yc.spring.bank.dao.AccountDao;
import com.yc.spring.bank.web.AccountAction;

/**
 * 配置Spring，让测试方法全部测试通过
 */
public class BankForAnnoTest {
	/**
	 * ClassPathXmlApplicationContext 		基于类路径XML配置
	 * AnnotationConfigApplicationContext 	基于注解配置
	 */
	AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(BankConfig.class);

	@Test
	public void test1() {
		AccountBiz ab = context.getBean(AccountBiz.class);
		AccountDao ad = context.getBean(AccountDao.class);
		AccountAction aa = context.getBean(AccountAction.class);
		
		Assert.assertNotNull(ab);
		Assert.assertNotNull(ad);
		Assert.assertNotNull(ad);
		
		/**
		 * 测试内部对象是否被注入
		 */
		Assert.assertNotNull(ab.getAd());
		Assert.assertNotNull(aa.getAb());
	}

}

