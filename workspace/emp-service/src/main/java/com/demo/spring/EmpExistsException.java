package com.demo.spring;

public class EmpExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmpExistsException(int id) {
		super("EMployee Exists with id "+id);
	}
}
