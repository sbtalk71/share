package com.demo.spring.app2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		EmpApp app = (EmpApp) ctx.getBean("empApp");

		app.regsiterEmp();
	}

}
