package com.telusko.demoHQL;

import java.util.List;
import java.util.Random;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
   	

    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sf =con.buildSessionFactory(reg);
    	Session session=sf.openSession();
    	org.hibernate.Transaction tx = session.beginTransaction();
    	
    	/* Random r =new Random();
    	
    	for(int i=1;i<=50;i++)
    	{
    		Student s =new Student();
    		s.setRollno(i);
    		s.setSname("Name" + i);
    		s.setMarks(r.nextInt(100));
    		session.save(s);
    	}  */
    	
    	/* Query q = session.createQuery("from StudentHql where marks > 50");
    	List<Student> students = q.list();
    	
    	for(Student s:students)
    	{
    		System.out.println(s);
    	} */
    	
    	Query q = session.createQuery("select rollno,marks from StudentHql where rollno=6");
    	Object[] students = (Object[]) q.uniqueResult();
    	
    	System.out.println();
    	 
    	
    	tx.commit();
    	
    }
}

