package com.HibernateExp.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.HibernateExp.pojo.Student;

public class HibernateMain {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sf=meta.getSessionFactoryBuilder().build();
		
		Session session=sf.openSession();
		
		session.beginTransaction();
		
		Student ob=new Student();
		ob.setName("Bhanoo Singh");
		ob.setCourse("Devops/GNIIT");
		
		session.save(ob);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Data inserted");
	}

}
