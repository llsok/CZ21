package com.yc.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.yc.spring.bank.bean.Account;
import com.yc.spring.bbs.bean.Page;
import com.yc.spring.bbs.bean.User;

/**
 *	Spring 注解配置类 ==》 IOC01.xml 
 *	SpringIOC容器配置注解 @Configuration  ==》 beans.xml
 */
@Configuration
public class IOC01Config {
	
	@Bean() // ==> <bean ...>...</bean>
	public User myUser() {
		User user = new User();
		user.setUname("武松");
		user.setUpass("abc123");
		user.setHead("20.gif");
		user.setGender(1);
		return user;
	}
	
	/**
	 * 方法名 == id
	 */
	@Bean
	public Account account() {
		return new Account();
	}
	
	/**
	 * value 是当前注解的默认的属性
	 * @return
	 */
	@Bean
	/**
	 * 作用域注解  等效于 bean 的 scope 属性
	 */
	@Scope("prototype")
	public Account account1() {
		return new Account();
	}

	/**
	 * 自动装载注解：spring会在IOC中查找对应的bean，并且设置进来
	 */
	@Autowired
	/**
	 * 限定 id 值   <ref bean="myUser"/>
	 */
	@Qualifier("myUser")
	private User user1;
	
	@Bean
	public Page page2() {
		Page p = new Page();
		p.setTotal(200);
		p.setRows(new ArrayList<>());
		
		User u =  new User();
		u.setUname("华荣");
		p.getRows().add(u);
		
		Map<String,String> m = new HashMap<>();
		m.put("0734", "衡阳");
		m.put("0731", "长沙");
		p.getRows().add(m);
		
		Set<Object> s = new HashSet<>();
		s.add(100);
		s.add("呵呵");
		// 添加 spring 自动装载的 user1 对象
		s.add(user1);
		p.getRows().add(s);
		
		return p;
	}
	
}

