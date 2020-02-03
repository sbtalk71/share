package com.demo.spring.exceptions;

public class EmpNotFoundException extends RuntimeException {
	public EmpNotFoundException() {

	}

	public EmpNotFoundException(String message) {
		super(message);
	}

}
