package com.yc.mvc;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.yc.mvc.dao")
@EnableTransactionManagement
public class MvcApp {

	public static void main(String[] args) {
		SpringApplication.run(MvcApp.class, args);
	}

}
