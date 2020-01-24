package com.demo.hibernate;

import java.util.HashSet;
import java.util.Set;

public class Emp {

	private int empId;
	private Name name;
	private String city;
	private double salary;
	private Set<Image> images=new HashSet<>();
	
	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Emp() {
		
	}

	public Emp(int empId, Name name, String city, double salary) {
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
	
	public Emp(Name name, String city, double salary) {
		
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
