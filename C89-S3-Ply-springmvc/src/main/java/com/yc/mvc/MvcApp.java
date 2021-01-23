package com.yc.mvc;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc.mvc.web.AdminLoginInterceptor;
import com.yc.mvc.web.LoginInterceptor;

@SpringBootApplication
@MapperScan("com.yc.mvc.dao")

@EnableTransactionManagement

public class MvcApp implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(MvcApp.class, args);
	}

	/**
	 * 	注册拦截器
	 * 	拦截资源的配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns(
				// 配置要拦截的资源
				"/user-*.html",
				"/getLoginedUser.do",
				"/addCart.do");
		registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns(
				"/back/manager/*.html",
				"/getAdminName");
	}

	/**
	 * 	静态资源映射配置， 大家自行扩展学习
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	
	
	
}
