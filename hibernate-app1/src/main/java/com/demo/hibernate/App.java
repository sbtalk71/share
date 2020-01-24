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
			Name name=new Name();
			name.setFirstName("Raunak");
			name.setLastName("Sharma");
			
			Emp e = new Emp(name, "Hyderabad", 56000);
			
			e.getImages().add(new Image("front.jpg",8,10));
			e.getImages().add(new Image("left.jpg",8,10));
			e.getImages().add(new Image("right.jpg",8,10));
			session.save(e);
			//session.flush();

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
