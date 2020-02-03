package com.demo.dao.impl;

import org.springframework.stereotype.Component;

import com.demo.dao.EmpDao;
import com.demo.entity.Emp;

@Component
public class EmpMockJdbcImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "Emp saved with id "+e.getEmpId();
	}

}
