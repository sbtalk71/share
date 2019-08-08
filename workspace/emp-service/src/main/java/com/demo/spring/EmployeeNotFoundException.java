package com.demo.spring;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(int id) {
		super("Employee Not Found with the given ID "+id);
	}

}
