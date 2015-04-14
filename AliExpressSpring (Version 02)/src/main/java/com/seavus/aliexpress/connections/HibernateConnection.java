package com.seavus.aliexpress.connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.seavus.aliexpress.model.Account;
import com.seavus.aliexpress.model.Product;

public class HibernateConnection {
	public static Session connection() {

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.addAnnotatedClass(Account.class).addAnnotatedClass(Product.class)
				.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();

	}
	
	public static void closeSession() {
		connection().close();
	}
}
