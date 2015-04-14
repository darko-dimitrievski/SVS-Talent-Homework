package com.seavus.aliexpress.hibernateTemplate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seavus.aliexpress.connections.HibernateConnection;

public class HIbernateTemplate {
	public <E> E returnQuery(HibernateReader databaseReader) {
		Session session = HibernateConnection.connection();
		Transaction tx = null;
		E object;
		try {
			tx = session.beginTransaction();
			object = databaseReader.returnQuery(session);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			HibernateConnection.closeSession();
		}

		return object;
	}

	public void executeQuery(HibernateWriter databaseWriter) {
		Session session = HibernateConnection.connection();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Object object = databaseWriter.insertQuery();
			session.saveOrUpdate(object);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			HibernateConnection.closeSession();
		}

	}
}
