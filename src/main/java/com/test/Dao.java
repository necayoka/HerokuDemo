package com.test;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class Dao {

	public static void addGrad(Grad grad) {
		Session session = getSession();
		session.beginTransaction();
		session.persist(grad);
		session.getTransaction().commit();
		session.close();
	}
	
	public static Grad showGrad(int id) {
		Session session = getSession();
		Grad grad = (Grad) session.get(Grad.class, id);
		session.close();
		
		return grad;
	}
	
	/**************************************************************************************************/
	
	private static final SessionFactory concreteSessionFactory;

	static {
		try {
			Properties prop = new Properties();
			prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");	//FIX
			prop.setProperty("hibernate.connection.url", "jdbc:postgresql://ec2-50-17-21-170.compute-1.amazonaws.com:5432/dbufblhturvsrt");	//FIX
			prop.setProperty("hibernate.connection.username", "edmrgjfgpxkfyr");	//FIX
			prop.setProperty("hibernate.connection.password", "95dcea6166e61595ad7f84bd6d94f562e02e9c9bd2095f2d75b6199688b2d9d7");	//FIX
			prop.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");	//FIX
			
			concreteSessionFactory = new AnnotationConfiguration().addPackage("com.test").addProperties(prop).addAnnotatedClass(Grad.class).buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		} 
	}
	
	public static Session getSession() {
		return concreteSessionFactory.openSession();
	}
	
}
