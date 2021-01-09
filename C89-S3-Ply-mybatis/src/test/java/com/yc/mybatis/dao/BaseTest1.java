package com.yc.mybatis.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.yc.mybatis.bean.JsjBook;
import com.yc.mybatis.bean.JsjSearch;
import com.yc.mybatis.bean.JsjUser;

public class BaseTest1 {

	private SqlSession session;

	@Before
	public void before() throws IOException {
		// 定义mybatis框架配置文件路径
		String resource = "mybatis.xml";
		// 读入配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 构建mybatis会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}

	@Test
	public void test1() throws IOException {
		SearchMapper sm = session.getMapper(SearchMapper.class);
		
		JsjSearch js = new JsjSearch();
		js.setKeyword("Java");
		js.setHots(9999);
		int rows = sm.insert(js);
		Assert.assertEquals(1, rows);
		
		System.out.println("js的id值:" + js.getId());
		
		session.commit();
		
		js = sm.selectById(1000);
		Assert.assertNull(js);
	}
	
	@Test
	public void test2() throws IOException {
		SearchMapper sm = session.getMapper(SearchMapper.class);
		JsjBook book = sm.queryById(3368828);
		Assert.assertEquals("初级会计实务", book.getName());
		Assert.assertEquals("33.00", book.getMarkPrice());
		Assert.assertEquals("I Do", book.getUser().getAccount());
		
		List<JsjBook> list = sm.queryByCategory("文学艺术");
		Assert.assertNotNull(list.get(0).getUser().getAccount());
		
	}

}
