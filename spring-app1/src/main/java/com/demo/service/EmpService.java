package com.demo.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.demo.dao.EmpDao;
import com.demo.entity.Emp;

@Service("Myservice")
//@Scope("prototype")
public class EmpService implements ApplicationContextAware{

	@Autowired
	@Qualifier("jpaDaoBean")
	EmpDao dao;

	public String registerEmp(int id, String name, String loc, double salary) {

		return dao.save(new Emp(id, name, loc, salary));

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(applicationContext.containsBean("appConfig"));
		
	}
}
