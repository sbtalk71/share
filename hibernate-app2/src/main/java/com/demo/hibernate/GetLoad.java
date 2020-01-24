package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetLoad {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Emp e=session.get(Emp.class, 104);
			System.out.println(e.getClass().getName());
			System.out.println(e.getEmpId());
			e.setCity("Mumbai");
			session.update(e);
			tx.commit();
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
