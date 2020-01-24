package com.demo.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {
	@Column(name="NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;

	public Name() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
