package com.yc.sq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 服务器注解
@EnableEurekaServer
public class EurekaApp {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaApp.class, args);
	}

}
