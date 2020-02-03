package com.demo.spring;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.demo.spring.entity.Emp;

@XmlRootElement(name="emp-list")
public class EmpRoot {
	//@XmlElement(name="emp")
	private List<Emp> emps;

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

}
