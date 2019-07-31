package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) throws Exception{
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("context.xml");

		WriterApp app=(WriterApp)ctx.getBean("app");
		
		app.print("lets go for Tea");
	}

}
