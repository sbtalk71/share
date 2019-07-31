package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WriterApp {

	@Autowired
	@Qualifier("decoratedWriter")
	private Writer writer;
	
/*
	public void setWriter(Writer writer) {
		System.out.println("Injected Object : "+writer.getClass().getName());
		this.writer = writer;
	}*/


	public void print(String message) {
		
		writer.write(message);
	}
}
