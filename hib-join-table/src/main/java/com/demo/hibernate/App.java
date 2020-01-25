package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			/*
			Person p = new Person();
			p.setId(100);
			p.setName("Karan");

			Employee e = new Employee();
			e.setId(101);
			e.setName("Juli");
			e.setSalary(90000);

			TraineeEmp te = new TraineeEmp();
			te.setId(102);
			te.setName("John");
			te.setSalary(80000);
			te.setPerformance("good");

			session.save(p);
			session.save(e);
			session.save(te);
			
			tx.commit();
			*/
			
			TraineeEmp t1= session.get(TraineeEmp.class, 103);
			
		} catch (HibernateException e) {
			tx.rollback();
			System.out.println("rolled back..");
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}

	}

}
