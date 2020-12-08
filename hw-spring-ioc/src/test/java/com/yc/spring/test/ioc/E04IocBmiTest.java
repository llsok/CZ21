package com.yc.spring.test.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.spring.BmiBeanConfig;
import com.yc.spring.bmi.Container;
import com.yc.spring.bmi.Person;

/**
 * 这是 Spring 测试注解，它自动完成ApplicationContext对象创建，
 * 可以自动注入  Spring IOC 容器的中的 Bean
 */
@RunWith(SpringRunner.class)
/**
 * 测试读入注解配置类的配置文件，等效于
 * ApplicationContext cxt = 
			new AnnotationConfigApplicationContext(BmiBeanConfig.class);
 */
@ContextConfiguration(classes = BmiBeanConfig.class)
public class E04IocBmiTest {
	
	@Autowired
	private Container container;
	
	@Test
	public void test() throws Exception{
		
		Person minP = (Person) container.getMin();
		Person maxP = (Person) container.getMax();
		
		assertTrue(container.getList().size() > 10);
		assertEquals("宋江", maxP.getName());
		assertEquals("燕青", minP.getName());
		
	}

}
