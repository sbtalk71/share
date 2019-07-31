package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class PlainTextWriter implements Writer{

	public void write(String message) {
		System.out.println("PlainText :"+message);
		
	}

}
