package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class App2 {

	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx= session.beginTransaction();
		
		try {
			
			//Dept dept=session.load(Dept.class, 20);
			
			Dept dept=new Dept(40, "HR", "Someone");
			Emp e1=new Emp(120, "Kirthi", "Mumbai", 67000);
			
			Emp e2=new Emp(121, "Charan", "Kolkata", 57000);
			
			session.save(dept);
			
			e1.setDept(dept);
			session.save(e1);
			
			e2.setDept(dept);
			session.save(e2);
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
