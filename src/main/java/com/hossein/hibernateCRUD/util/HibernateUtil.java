package com.hossein.hibernateCRUD.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.hossein.hibernateCRUD.model.Student;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
				settings.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521/pdbdev");
				settings.put(Environment.USER, "hossein");
				settings.put(Environment.PASS, "rekaeil");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.Oracle10gDialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Student.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sessionFactory;
	}
}
