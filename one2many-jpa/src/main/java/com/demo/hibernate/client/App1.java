package com.demo.hibernate.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class App1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Dept dept = em.find(Dept.class, 20);
			Emp e1 = new Emp(200, "Chandra", "Hyderabad", 60000);
			Emp e2 = new Emp(201, "Arun", "Hyderabad", 50000);
			
			e1.setDept(dept);
			e2.setDept(dept);
			
			em.persist(e1);
			em.persist(e2);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}

}
