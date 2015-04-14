package com.seavus.aliexpress.crud.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.seavus.aliexpress.crud.dao.ProductDao;
import com.seavus.aliexpress.hibernateTemplate.HIbernateTemplate;
import com.seavus.aliexpress.hibernateTemplate.HibernateReader;
import com.seavus.aliexpress.hibernateTemplate.HibernateWriter;
import com.seavus.aliexpress.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	boolean flagId = false;
	boolean flagName = false;
	int quantityById;
	int quantityByName;

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		new HIbernateTemplate().executeQuery(new HibernateWriter() {

			@Override
			public Object insertQuery() {
				// TODO Auto-generated method stub
				return p;
			}
		});
	}

	@Override
	public List<Product> listAllProducts() {
		// TODO Auto-generated method stub
		return new HIbernateTemplate().returnQuery(new HibernateReader() {

			@Override
			public List<Object> returnQuery(Session session) {
				// TODO Auto-generated method stub
				Query query = session.createQuery("FROM Product");
				return query.list();
			}
		});
	}

	@Override
	public void updateProductQuantity(int quantity, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub

	}

	public List<Product> adminListAllProducts() {
		return new HIbernateTemplate().returnQuery(new HibernateReader() {

			@Override
			public List<Object> returnQuery(Session session) {
				// TODO Auto-generated method stub
				Query query = session.createQuery("FROM Product");
				return query.list();
			}
		});
	}

	public boolean checkProductById(int id) {
		new HIbernateTemplate().returnQuery(new HibernateReader() {
			@Override
			public <E> E returnQuery(Session session) {
				// TODO Auto-generated method stub
				String hql = "From Product p WHERE p.id = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				if (query.list().size() > 0)
					flagId = true;
				else
					flagId = false;
				return null;
			}
		});
		return flagId;
	}

	public boolean checkProductByName(String name) {
		new HIbernateTemplate().returnQuery(new HibernateReader() {
			@Override
			public <E> E returnQuery(Session session) {
				// TODO Auto-generated method stub
				String hql = "From Product p WHERE p.name = :name";
				Query query = session.createQuery(hql);
				query.setParameter("name", name);
				if (query.list().size() > 0)
					flagName = true;
				else
					flagName = false;
				return null;
			}
		});
		return flagName;
	}

	public int getQuantityByName(String name) {
		new HIbernateTemplate().returnQuery(new HibernateReader() {
			@Override
			public <E> E returnQuery(Session session) {
				// TODO Auto-generated method stub
				String hql = "Select p.quantity FROM Product p WHERE name = :name";
				Query query = session.createQuery(hql);
				query.setParameter("name", name);
				quantityByName = (int) query.uniqueResult();
				return null;
			}
		});
		return quantityByName;
	}

	public int getQuantityById(int id) {
		new HIbernateTemplate().returnQuery(new HibernateReader() {
			@Override
			public <E> E returnQuery(Session session) {
				// TODO Auto-generated method stub
				String hql = "Select p.quantity FROM Product p WHERE id = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				quantityById = (int) query.uniqueResult();
				return null;
			}
		});
		return quantityById;
	}
	public Product findProductById(final int id) {
		return new HIbernateTemplate().returnQuery(new HibernateReader() {

			@Override
			public Product returnQuery(Session session) {
				// TODO Auto-generated method stub
				Criteria cr = session.createCriteria(Product.class);
				cr.add(Restrictions.eq("id", id));
				List results = cr.list();
				Product p = (Product) results.get(0);
				return p;
			}
		});

	}
}
