package com.yc.spring.bank;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // beans.xml
@ComponentScan("com.yc.spring.bank")  // 组件扫描注解, 定义组件所在的包
public class BankConfig {
	
	/*	@Bean
		public AccountBiz getBiz() {
			return new AccountBiz();
		}
	*/
	
	/**
	 * 组件注解
	 * @Component  组件注解直接加到类名上 替代  @Bean 注解
	 * 	通用的组件组件
	 * 		组件语义组件， 提升代码的可读性，功能与 Component 基本一致
	 * 		@Controller 控制层
	 * 		@Service    业务层
	 * 		@Repository 数据访问层
	 */
}
