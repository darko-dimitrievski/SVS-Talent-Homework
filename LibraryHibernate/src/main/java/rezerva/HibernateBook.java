package rezerva;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entities.Book;

public class HibernateBook{

	public static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(
				Book.class).buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public void addBook(String isbn, String title) {
		Session session = createSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book = new Book();
			book.setIsbn(isbn);
			book.setTitle(title);
			session.save(book);
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;

		} finally {
			session.close();
		}
	}

	public void listAllBooks() {
		Session session = createSessionFactory().openSession();
		Query query = session.createQuery("FROM Book");
		List results = query.list();
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
	}

	public void updateBook(String isbn, String title) {
		// TODO Auto-generated method stub
		Session session = createSessionFactory().openSession();
		String hql = "UPDATE Book set title = :title WHERE isbn = :isbn";
		Query query = session.createQuery(hql);
		query.setParameter("title", title);
		query.setParameter("isbn", isbn);
		query.executeUpdate();

	}

	public void deleteBook(String isbn) {

		Session session = createSessionFactory().openSession();
		String hql = "DELETE FROM Book WHERE isb = :" + isbn;
		Query query = session.createQuery(hql);
		query.executeUpdate();

	}
}
