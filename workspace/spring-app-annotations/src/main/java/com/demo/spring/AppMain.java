package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	public static void main(String[] args) throws Exception{
		
		ApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);

		WriterApp app=(WriterApp)ctx.getBean("writerApp");
		
		app.print("lets go for Tea");
	}

}
