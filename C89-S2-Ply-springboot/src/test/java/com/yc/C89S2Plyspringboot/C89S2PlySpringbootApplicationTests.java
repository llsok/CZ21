package com.yc.C89S2Plyspringboot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

// SpringBoot 自带的测试类
@SpringBootTest
class C89S2PlySpringbootApplicationTests {

	@Resource
	private JdbcTemplate jt;
	
	@Test
	void contextLoads() {
		Assert.notNull(jt, "jt不能为空");
		jt.update("insert into account values(null,?,?,?)", 5000, "李四", "123");
		jt.update("insert into account values(null,?,?,?)", 5000, "王五", "123");
		jt.update("insert into account values(null,?,?,?)", 5000, "赵柳", "123");
		jt.update("insert into account values(null,?,?,?)", 5000, "刘七", "123");
	}

}
