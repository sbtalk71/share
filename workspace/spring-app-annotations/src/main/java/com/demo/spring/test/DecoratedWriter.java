package com.demo.spring.test;

import org.springframework.stereotype.Component;

import com.demo.spring.Writer;

@Component
public class DecoratedWriter implements Writer{

	public void write(String message) {
		System.out.println("Decorated Writer :"+message);
		
	}

}
