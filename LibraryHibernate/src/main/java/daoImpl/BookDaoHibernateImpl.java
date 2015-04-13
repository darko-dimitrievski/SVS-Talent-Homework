package daoImpl;

import hibernateTemplate.HIbernateTemplate;
import hibernateTemplate.HibernateReader;
import hibernateTemplate.HibernateWriter;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.BookDao;
import entities.Book;
import entities.Publication;

public class BookDaoHibernateImpl implements BookDao {

	public void addBook(final Book book) {
		// TODO Auto-generatedmethod stub
		new HIbernateTemplate().executeQuery(new HibernateWriter() {
			
			public Object insertQuery() {
				// TODO Auto-generated method stub
				return book;
			}
		});
	}

	public List<Book> listAllBooks() {
		// TODO Auto-generated method stub
		
		return new HIbernateTemplate().returnQuery(new HibernateReader() {
			
			public List<Object> returnQuery(Session session) {
				// TODO Auto-generated method stub
				Query query = session.createQuery("FROM Book");
				return query.list();
				
			}
		});
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		
	}
	
}
