package query;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Emp;

public class NativeQueryDemo {

	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx= session.beginTransaction();
		
		try {
			
			
			NativeQuery query1=session.createNativeQuery("select empno,name,address,salary from myemp where salary between ?1 and :high");
			query1.setParameter("high", 70000.0);
			//query1.setInteger("high", 60000);
			query1.setParameter(1, 10000.0);
			
			List<Object[]> empList1=query1.getResultList();
			
			empList1.stream().forEach(e->System.out.println((Integer)e[0]+" "+(String)e[1]+" "+(String)e[2]+" "+(Double)e[3]));
			
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}

	}

}
