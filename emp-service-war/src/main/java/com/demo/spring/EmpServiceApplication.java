package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmpServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EmpServiceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		System.out.println("Your Application booting in server....");
		return builder.sources(EmpServiceApplication.class);
	}
}
