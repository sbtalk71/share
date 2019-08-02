package com.demo.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class BankDaoJpaImpl implements BankDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public String createCustomer(Customer c) {
		em.persist(c);
		return "success";
	}

}
