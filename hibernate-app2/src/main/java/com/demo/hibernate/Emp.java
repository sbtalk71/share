package com.demo.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="EMP")
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="EMPNO")
	private int empId;
	
	@Embedded
	private Name name;
	
	@Column(name="ADDRESS")
	private String city;
	
	@Column(name="SALARY")
	private double salary;
	
	@ElementCollection(targetClass = Image.class)
	@JoinTable(name = "IMAGES", joinColumns = @JoinColumn(name = "EMPNO"))
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
