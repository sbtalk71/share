package com.demo.hibernate.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.demo.hibernate.Emp;

public class AppQuery {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			// tx.begin();
			/*
			 * Query query = em.createQuery("select e from Emp e where e.sal>30000");
			 * 
			 * List<Emp> empList = query.getResultList();
			 * 
			 * empList.stream().forEach(e -> System.out.println(e.getEmpId() + " " +
			 * e.getEmpName() + " " + e.getSal()));
			 * 
			 * Query query1 =
			 * em.createQuery("select e.empName,e.sal from Emp e where e.sal>30000");
			 * 
			 * List<Object[]> empList1 = query1.getResultList();
			 * 
			 * empList1.stream().forEach(e -> System.out.println((String)e[0] + " " +
			 * (Double)e[1] ));
			 */

			Query nq1=em.createNamedQuery("empwithsal");
			nq1.setParameter(1, 30000.0);
			
			List<Emp> empList2 = nq1.getResultList();

			empList2.stream().forEach(e -> System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getSal()));
			// tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}

}
