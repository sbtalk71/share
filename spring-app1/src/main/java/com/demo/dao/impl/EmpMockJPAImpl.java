package com.demo.dao.impl;

import org.springframework.stereotype.Component;

import com.demo.dao.EmpDao;
import com.demo.entity.Emp;


public class EmpMockJPAImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "JPA: Emp saved with id "+e.getEmpId();
	}

}
