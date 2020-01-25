package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class App1 {

	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx= session.beginTransaction();
		
		try {
			
			Dept dept=session.load(Dept.class, 20);
			
			Emp e1=new Emp(116, "Karan", "Mumbai", 67000);
			
			Emp e2=new Emp(117, "Madan", "Kolkata", 57000);
			
			dept.getEmps().add(e1);
			dept.getEmps().add(e2);
			
			session.update(dept);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}

	}

}
