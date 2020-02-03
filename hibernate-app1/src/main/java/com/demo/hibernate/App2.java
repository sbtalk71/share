package com.demo.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App2 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Emp e = new Emp("Kiran", "Bangalore", 56000.0);
			/*
			 * e.getImages().add("front.jpg"); e.getImages().add("back.jpg");
			 */

			Set<String> img = new HashSet<>();
			img.add("right.jpg");
			img.add("left.jpg");
			e.setImages(img);
			session.save(e);
			session.flush();

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
