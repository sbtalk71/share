package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.service.EmpService;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);

		//EmpService service=(EmpService)ctx.getBean("Myservice");
		EmpService service=ctx.getBean(EmpService.class);
		
		String resp=service.registerEmp(100, "A", "B", 90000);
		System.out.println(resp);
		
		
		EmpService service1=ctx.getBean(EmpService.class);
		
		System.out.println(service==service1);
	}

}
