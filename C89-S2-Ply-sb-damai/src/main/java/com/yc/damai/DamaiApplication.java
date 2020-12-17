package com.yc.damai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DamaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DamaiApplication.class, args);
	}
	
}
