package com.seavus.aliexpress.crud.dao;

import java.util.ArrayList;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;
import com.seavus.aliexpress.crud.model.Product;


@Repository
public class ProductDaoImpl implements ProductDao {

	public static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(
				Product.class).buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		Session session = createSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(p);
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

	public void listAllProducts() {
		Session session = createSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Product.class);
			ArrayList<Product> products = (ArrayList<Product>) cr.list();
			for (Product p : products) {
				System.out.println(p.toString());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateProductQuantity(int quantity, int id) {
		Session session = createSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Product product = (Product) session.get(Product.class, id);
			product.setQuantity(quantity);
			session.update(product);
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}

	}

	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		Session session = createSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Product product = (Product) session.get(Product.class, id);
			session.delete(product);
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}

	}

	public void adminListAllProducts() {
		Session session = createSessionFactory().openSession();
		String hql = "FROM Product";
		Query query = session.createQuery(hql);
		ArrayList<Product> results = (ArrayList<Product>) query.list();
		for (Product p : results) {
			System.out.println(p.adminToString());
		}

	}
	
	public boolean checkProduct(int id){
		Session session = createSessionFactory().openSession();
		String hql = "FROM Product WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size() > 0) return true;
		else return false;
	}
	
	public int selectQuantity(int id){
		Session session = createSessionFactory().openSession();
		String hql = "Select p.quantity from Product p where id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		return (int) query.uniqueResult();
	}

}
