package com.yc.favorite;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1. SpringBoot 如何集成 MyBatis ==》 其它框架
 * 		分析源码
 * 		@SpringBootApplication  组合注解
 * 			@SpringBootConfiguration ==》Spring IOC 容器注解配置类 1. xml，2.注解， 3.xml+注解
			@ComponentScan			 ==》组件扫描注解
			@EnableAutoConfiguration ==》SpringBoot 自动配置注解
				@AutoConfigurationPackage 自动配置包
				@Import					  导入自动配置选择器
					META-INF/spring.factories 记录了所有的启动类
				
				MybatisAutoConfiguration MyBatis 自动配置类
				@Configuration
				@ConditionalOnClass({ SqlSessionFactory.class, SqlSessionFactoryBean.class })
				@ConditionalOnBean(DataSource.class)
				@EnableConfigurationProperties(MybatisProperties.class)
				@AutoConfigureAfter(DataSourceAutoConfiguration.class)
				public class MybatisAutoConfiguration {
				
				Conditional 鉴权
					@ConditionalOnClass 语义： 如果类路径中包含指定的类，那么启动配置
					@ConditionalOnBean  语义： 如果IOC容器中包含指定的bean， 那么启动配置
					@Bean + @ConditionalOnMissingBean 方法上： 如果IOC容器没有某个bean ， 那么我来配置
				
 * 
 * 2. 为什么提示 SpringBootConfiguration 注解没有配置
 * @author Administrator
 *
 */
@SpringBootApplication
@MapperScan("com.yc.favorite.dao")
public class FavoriteApp {
	public static void main(String[] args) {
		SpringApplication.run(FavoriteApp.class, args);
	}
}
