package com.yc.C89S3Plycloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 开启Eureka 服务
@EnableEurekaServer
@SpringBootApplication
public class C89S3PlyCloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(C89S3PlyCloudServerApplication.class, args);
	}

}
