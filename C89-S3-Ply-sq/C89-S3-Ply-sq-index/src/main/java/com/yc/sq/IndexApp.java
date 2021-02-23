package com.yc.sq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IndexApp {
	
	public static void main(String[] args) {
		SpringApplication.run(IndexApp.class, args);
	}

}
