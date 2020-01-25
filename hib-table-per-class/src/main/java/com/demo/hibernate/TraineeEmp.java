package com.demo.hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINEE3")
public class TraineeEmp extends Employee {
	private String performance;

	public TraineeEmp() {
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

}
