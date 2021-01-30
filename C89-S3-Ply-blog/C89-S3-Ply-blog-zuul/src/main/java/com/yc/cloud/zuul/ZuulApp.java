package com.yc.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
/**
 * @EnableZuulProxy，其中@EnableZuulProxy包含@EnableZuulServer的功能，
 * 	而且还加入了@EnableCircuitBreaker和@EnableDiscoveryClient。
 */
@EnableZuulProxy
public class ZuulApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ZuulApp.class, args);
	}

}
