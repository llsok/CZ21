package com.yc.damai;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		
		HttpServletResponse a;
		
		return application.sources(DamaiApplication.class);
	}

}
