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
			prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/gradovi");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "panzer");
			prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
			prop.setProperty("hbm2ddl.auto", "update");
			prop.setProperty("show_sql", "true");
			prop.setProperty("format_sql", "true");
			
			concreteSessionFactory = new AnnotationConfiguration().addPackage("com.test").addProperties(prop).addAnnotatedClass(Grad.class).buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		} 
	}
	
	public static Session getSession() {
		return concreteSessionFactory.openSession();
	}
	
}
