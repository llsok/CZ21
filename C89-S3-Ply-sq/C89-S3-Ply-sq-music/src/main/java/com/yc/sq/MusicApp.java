package com.yc.sq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yc.sq.dao")
public class MusicApp {
	
	public static void main(String[] args) {
		SpringApplication.run(MusicApp.class, args);
	}

}
