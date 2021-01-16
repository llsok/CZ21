package com.yc.mvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.mvc.dao")
public class MvcApp {

	public static void main(String[] args) {
		SpringApplication.run(MvcApp.class, args);
	}

}
