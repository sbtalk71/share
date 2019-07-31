package com.demo.spring.app2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages = "com.demo.spring.app2")
public class AppConfig {

	/*
	 * @Bean public ResourceBundleMessageSource messageSource() {
	 * ResourceBundleMessageSource resource=new ResourceBundleMessageSource();
	 * resource.setBasename("names"); return resource; }
	 */
}
