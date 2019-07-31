package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) throws Exception{
		/*BeanFactory factory=new XmlBeanFactory(
				new FileSystemResource("F:\\workspaces\\workspace19\\TA-DBS\\spring-app-xml\\src\\main\\resources\\context.xml"));
		*/
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("context.xml");

		//Mail mail=(Mail)ctx.getBean("mymail");
		
		System.in.read();
		Mail mail=ctx.getBean(Mail.class);
		
		System.out.println(mail.getMessage().getBody());
		
		
		mail.getMessage().setBody("We will take no break today");
		
		Mail mail1=(Mail)ctx.getBean("mymail");
		System.out.println(mail1.getMessage().getBody());
	}

}
