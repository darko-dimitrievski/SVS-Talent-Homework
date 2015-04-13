package connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entities.Book;
import entities.Loan;
import entities.Magazine;
import entities.Member;
import entities.Membership;
import entities.Publication;

public class HibernateConnection {
	public static Session connection() {

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.addAnnotatedClass(Book.class).addAnnotatedClass(Loan.class)
				.addAnnotatedClass(Magazine.class)
				.addAnnotatedClass(Member.class)
				.addAnnotatedClass(Membership.class)
				.addAnnotatedClass(Publication.class)
				.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();

	}
	
	public static void closeSession() {
		connection().close();
	}
}
