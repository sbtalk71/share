package query;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Emp;

public class HQL1 {

	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx= session.beginTransaction();
		
		try {
			Query query=session.createQuery("from Emp");
			List<Emp> empList=query.getResultList();
		
			empList.stream().forEach(e->System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getSal()));
			
			
			//Query query1=session.createQuery("select new Emp(e.empId,e.empName,e.city,e.sal) from Emp e");
			//Query query1=session.createQuery("select e.empId,e.empName,e.city,e.sal from Emp e where e.sal between ? and ?");
			Query query1=session.createQuery("select e.empId,e.empName,e.city,e.sal from Emp e where e.sal between ?1 and :high");
			//query1.setInteger(0, 30000);
			//query1.setInteger(1, 70000);
			query1.setParameter("high", 30000.0);
			//query1.setInteger("high", 60000);
			query1.setParameter(1, 70000.0);
			
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
