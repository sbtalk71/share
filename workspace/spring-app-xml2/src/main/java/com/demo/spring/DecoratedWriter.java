package com.demo.spring;

public class DecoratedWriter implements Writer{

	public void write(String message) {
		System.out.println("Decorated Writer :"+message);
		
	}

}
