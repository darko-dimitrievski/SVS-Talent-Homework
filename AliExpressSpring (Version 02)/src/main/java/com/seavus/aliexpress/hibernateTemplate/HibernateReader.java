package com.seavus.aliexpress.hibernateTemplate;

import java.util.List;

import org.hibernate.Session;

public interface HibernateReader {
	<E> E returnQuery(Session session);
}