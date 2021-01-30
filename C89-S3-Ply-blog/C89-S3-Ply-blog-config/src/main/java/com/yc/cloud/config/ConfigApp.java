package com.yc.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
// 开启配置中心服务
@EnableConfigServer
public class ConfigApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigApp.class, args);
	}

}
