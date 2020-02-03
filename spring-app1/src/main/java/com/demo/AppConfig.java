package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.dao.EmpDao;
import com.demo.dao.impl.EmpMockJPAImpl;

@Configuration
@ComponentScan(basePackages = "com.demo")
public class AppConfig {

	@Bean
	public EmpDao jpaDaoBean() {
		return new EmpMockJPAImpl();
	}
}
