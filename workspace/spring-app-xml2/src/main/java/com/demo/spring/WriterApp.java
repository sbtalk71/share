package com.demo.spring;

public class WriterApp {

	private Writer writer;
	

	public void setWriter(Writer writer) {
		System.out.println("Injected Object : "+writer.getClass().getName());
		this.writer = writer;
	}


	public void print(String message) {
		
		writer.write(message);
	}
}
