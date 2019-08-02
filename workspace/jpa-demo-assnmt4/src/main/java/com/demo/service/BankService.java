package com.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Account;
import com.demo.entity.BankDao;
import com.demo.entity.Customer;

@Service
public class BankService {

	@Autowired
	BankDao dao;

	public String addCustomer(int id,String name, double minBal) {
		Account acc = new Account();
		acc.setBalance(minBal);
		Set<Account> accounts=new HashSet<>();
		accounts.add(acc);
		
		Customer c= new Customer(id, name, accounts);
		return dao.createCustomer(c);
		
	}
}
