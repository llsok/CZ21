package com.yc.thread.d0102;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppTest {
	
	@Resource
	private BankServer server;
	
	@Test
	public void testBenkService() throws IOException {
		server.begin();
	}
	
}
