package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

		Trainer trainer = ctx.getBean(Trainer.class);

		for (Participant p : trainer.getParticipants()) {

			LunchBox lb = p.getLunchBox();
			for (Item item : lb.getItems()) {
				System.out.println(item.getName() + " " + item.getTaste());
			}
		}

	}

}
