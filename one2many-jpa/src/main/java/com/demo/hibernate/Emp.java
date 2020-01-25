package com.demo.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "MYEMP")
@NamedQueries({
	@NamedQuery(name = "empwithsal",query = "select e from Emp e where e.sal>?1"),
	@NamedQuery(name = "all",query = "select e from Emp e")
	})
public class Emp {
	@Id
	@Column(name = "EMPNO")
	private int empId;

	@Column(name = "NAME")
	private String empName;

	@Column(name = "ADDRESS")
	private String city;

	@Column(name = "SALARY")
	private double sal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="DNO")
	private Dept dept;

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public Emp(int empId, String empName, String city, double sal) {
		this.empId = empId;
		this.empName = empName;
		this.city = city;
		this.sal = sal;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

}
