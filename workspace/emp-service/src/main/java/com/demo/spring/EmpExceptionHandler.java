package com.demo.spring;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class EmpExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ModelAndView exception(EmployeeNotFoundException ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("errors");
		mv.addObject("message", ex.getMessage());
		return mv;
	}

	@ExceptionHandler(EmpExistsException.class)
	public ModelAndView exception(EmpExistsException ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("errors");
		mv.addObject("message", ex.getMessage());
		return mv;
	}
}
