package com.telusko.demoHIbernateRelation;

import javax.transaction.Transaction;

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
    	Laptop l1 =new Laptop();
    	l1.setLid(10);
    	l1.setLname("Hp");
    	
    	Student suresh = new Student();
    	suresh.setMarks(100);
    	suresh.setRollno(101);
    	suresh.setSname("suresh");
    	suresh.getLaptop().add(l1);
    	
    	l1.getStudent().add(suresh);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sf =con.buildSessionFactory(reg);
    	Session session=sf.openSession();
    	org.hibernate.Transaction tx = session.beginTransaction();
    	
    	session.save(suresh);
    	session.save(l1);

    	
    	//suresh=(Alien)session.get(Alien.class,101); //this to get data from database
    	
    	tx.commit();
    	
    	System.out.println(suresh);
    }
}
