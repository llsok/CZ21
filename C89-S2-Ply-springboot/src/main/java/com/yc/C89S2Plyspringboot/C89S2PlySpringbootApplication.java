package com.yc.C89S2Plyspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
// 开启定时任务的服务
@EnableScheduling
public class C89S2PlySpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(C89S2PlySpringbootApplication.class, args);
	}
	
	/**
	 * WebSocket 服务器对象
	 * @return
	 */
	@Bean 
	public ServerEndpointExporter serverEndpointExporter() { 
		return new ServerEndpointExporter(); 
	} 
	
}
