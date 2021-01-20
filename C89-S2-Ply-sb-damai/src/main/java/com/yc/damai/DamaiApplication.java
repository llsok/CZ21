package com.yc.damai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//开启定时任务的服务
@EnableScheduling
public class DamaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DamaiApplication.class, args);
	}
	
}
