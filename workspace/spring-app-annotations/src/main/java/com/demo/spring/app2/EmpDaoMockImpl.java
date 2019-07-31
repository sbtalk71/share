package com.demo.spring.app2;

import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoMockImpl implements EmpDao {

	public void save(String name) {
		System.out.println("Data for "+name+" is saved");

	}

}
