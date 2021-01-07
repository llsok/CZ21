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
import com.yc.mybatis.bean.JsjCategory;
import com.yc.mybatis.bean.JsjSchool;
import com.yc.mybatis.bean.JsjSearch;
import com.yc.mybatis.bean.JsjUser;

public class BaseTest {
	
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
		List<Map<?,?>> list = session.selectList("com.yc.mybatis.dao.CategoryMapper.selectAll");
		for(Map<?,?> row : list) {
			System.out.println(row);
		}
	}
	
	/**
	 * java.lang.ClassCastException: java.util.HashMap cannot be cast to com.yc.mybatis.bean.JsjCategory
		at com.yc.mybatis.dao.BaseTest.test2(BaseTest.java:50)
	*/
	@Test
	public void test2() throws IOException {
		List<JsjCategory> list = session.selectList("com.yc.mybatis.dao.CategoryMapper.selectAll1");
		for(JsjCategory row : list) {
			System.out.println(row.getId() + "   " + row.getName());
		}
	}
	
	@Test
	public void test3() throws IOException {
		JsjCategory category = session.selectOne("com.yc.mybatis.dao.CategoryMapper.selectById", 3000);
		System.out.println(category.getId() + "   " + category.getName());
		
		// Map 传入多个参数
		HashMap<String,Object> params = new HashMap<>();
		params.put("name", "%海%");
		params.put("press", "%出版社%");
		List<JsjBook> list = session.selectList("com.yc.mybatis.dao.CategoryMapper.selectByNameAndPress", params);
		for(JsjBook row : list) {
			System.out.println(row.getName() + "   " + row.getPress());
		}
		
		System.out.println("======================");
		
		// 实体类 传入多个参数
		JsjBook book = new JsjBook();
		book.setName("%海%");
		book.setPress("%出版社%");
		list = session.selectList("com.yc.mybatis.dao.CategoryMapper.selectByNameAndPress", book);
		for(JsjBook row : list) {
			System.out.println(row.getName() + "   " + row.getPress());
		}
		
		// MyBatis 默认在执行完增删改之后,回滚数据库操作
		try {
			JsjSearch s = new JsjSearch();
			s.setKeyword("Spring");
			s.setHots(4567);
			session.insert("com.yc.mybatis.dao.CategoryMapper.insert",s);
			session.commit();
		} catch (Exception e ) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	@Test
	public void test4() {
		// getMapper JDK 动态代理(SpringAOP) 动态的生成了一个接口实现类
		UserMapper um = session.getMapper(UserMapper.class);
		JsjUser user = um.selectById(35256);
		System.out.println(user.getName());
	}
	
	/**
	 * 关联映射 : ==> 关联查询
	 * JsjBook 图书实体类 jsj_book
	 * jsjBook.ownerId 
	 * JsjBook book = selectById(id)
	 * book.getOwnerId
	 * 一次查询查出2个表的数据
	 * 关联查询  join 
	 * 
	 */
	@Test
	public void test5() {
		// getMapper JDK 动态代理(SpringAOP) 动态的生成了一个接口实现类
		BookMapper bm = session.getMapper(BookMapper.class);
		System.out.println("===========0============");
		JsjBook book = bm.selectById(6089377);
		// 验证图书信息
		System.out.println("===========1============");
		Assert.assertEquals("阿Q正传", book.getName());
		System.out.println("===========2============");
		Assert.assertEquals("20.00", book.getMarkPrice());
		System.out.println("===========3============");
		// 验证图书所有者的账号
		// Assert.assertEquals("西江石壁", book.getUser().getAccount());
		System.out.println("===========4============");
	}
	
	@Test
	public void test6() {
		UserMapper um = session.getMapper(UserMapper.class);
		JsjUser user = um.selectById(12418838);
		for(JsjBook book : user.getBooks()) {
			System.out.println(book.getName());
		}
		System.out.println(user.getAccount());
		System.out.println(user.getName());
		System.out.println(user.getPhone());
	}
	
	/**
	 * 多对多关联:
	 * 	用户 与 粉丝 关系
	 * 	jsj_user ==> jsj_fans 关系表
	 * 
	 * jsj_fans 中间表 ==> 关联查询 sql
	 * 
	 */
	@Test
	public void test7() {
		UserMapper um = session.getMapper(UserMapper.class);
		JsjUser user = um.selectById(35256);
		List<JsjUser> fans = user.getFans();
		Assert.assertEquals(12, fans.size());
		Assert.assertEquals("行者月季", fans.get(0).getAccount());
	}
	
	
	/**
	 * 	组合条件查询
	 * 	传统写法
	 * 	String sql = "select * from table where 1=1 "
	 * 	if ==> sql += " and  a = ?"
	 * 	params.add(值)
	 */
	@Test
	public void test8() {
		SchoolMapper sm = session.getMapper(SchoolMapper.class);
		System.out.println("==========1==========");
		JsjSchool s = null;
		sm.selectByObj(s);
		System.out.println("==========2==========");
		s = new JsjSchool();
		sm.selectByObj(s);
		System.out.println("==========3==========");
		s.setId(1);
		sm.selectByObj(s);
		System.out.println("==========4==========");
		s.setName("上海");
		sm.selectByObj(s);
		System.out.println("==========5==========");
		s.setProvince("上海");
		sm.selectByObj(s);
		System.out.println("==========6==========");
	}
	
	
	
	

}
