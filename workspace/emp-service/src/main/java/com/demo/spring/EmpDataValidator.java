package com.demo.spring;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.spring.entity.Emp;

@Component
public class EmpDataValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(Emp.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Emp e=(Emp)target;
		if(e.getId()<100) {
			errors.rejectValue("empId", "invalidId", "Id is not Valid");
		}if(e.getName().isEmpty()) {
			errors.rejectValue("name", "nameEmpty", "Name cannot be empty");
		}if(e.getCity().isEmpty()) {
			errors.rejectValue("city", "invalidCity", "City Cannot be Empty");
		}if(e.getSalary()<5000) {
			errors.rejectValue("salary", "invalidSal", "Salary cannot be less than 5000");
		}

	}

}
