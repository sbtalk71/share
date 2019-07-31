package com.demo.spring.app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@PropertySource("names.properties")
@Scope("singleton")
public class EmpApp {

	
	EmpDao dao;
	
	@Autowired
	public EmpApp(EmpDao dao) {
		this.dao=dao;
	}
	
	@Value("${name}")
	String name;
	
	public void regsiterEmp() {
		dao.save(name);
	}
}
