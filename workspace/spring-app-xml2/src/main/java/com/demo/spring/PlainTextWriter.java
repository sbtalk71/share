package com.demo.spring;

public class PlainTextWriter implements Writer{

	public void write(String message) {
		System.out.println("PlainText :"+message);
		
	}

}
