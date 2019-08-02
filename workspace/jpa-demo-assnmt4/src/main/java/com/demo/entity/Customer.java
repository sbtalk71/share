package com.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	@Id
	@Column(name = "CUST_ID")
	private int cutsId;
	@Column(name = "CUST_NAME")
	private String custName;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "CUST_ID")
	Set<Account> accounts = new HashSet<>();

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int cutsId, String custName, Set<Account> accounts) {
		this.cutsId = cutsId;
		this.custName = custName;
		this.accounts = accounts;
	}

	public int getCutsId() {
		return cutsId;
	}

	public void setCutsId(int cutsId) {
		this.cutsId = cutsId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
