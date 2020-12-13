package com.yc.C89S2Plyspringboot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.yc.C89S2Plyspringboot.biz.MailBiz;

// SpringBoot 自带的测试类
@SpringBootTest
class C89S2PlySpringbootApplicationTests {

	@Resource
	private JdbcTemplate jt;
	
	void contextLoads() {
		Assert.notNull(jt, "jt不能为空");
		jt.update("insert into account values(null,?,?,?)", 5000, "李四", "123");
		jt.update("insert into account values(null,?,?,?)", 5000, "王五", "123");
		jt.update("insert into account values(null,?,?,?)", 5000, "赵柳", "123");
		jt.update("insert into account values(null,?,?,?)", 5000, "刘七", "123");
	}
	
	@Resource
	private MailBiz mbiz;
	@Test
	void test1() {
		mbiz.sendSimpleMail("306529917@qq.com", "测试邮件", "我的测试邮件：测试邮件");
	}

}
