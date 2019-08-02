package com.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.service.BankService;
import com.demo.spring.JpaConfig;

public class SpringJpaMain {

	public static void main(String[] args) {
		ApplicationContext ctx=
				new AnnotationConfigApplicationContext(JpaConfig.class);
		BankService service=(BankService)ctx.getBean("bankService");
		System.out.println(service.addCustomer(101, "Nakul", 2000));

	}

}
