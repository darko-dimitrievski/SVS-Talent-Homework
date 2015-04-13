package service;

import java.util.List;

import dao.BookDao;
import daoImpl.BookDaoHibernateImpl;
import entities.Book;
import entities.Publication;
import factoryDao.FactoryDao;

public class LibraryServiceImpl implements LibraryService {

	public BookDao bookDaoImpl;

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookDaoImpl.addBook(book);
	}

	public List<Book> listAllBooks() {
		// TODO Auto-generated method stub
		return bookDaoImpl.listAllBooks();
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookDaoImpl.updateBook(book);
	}

	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		bookDaoImpl.deleteBook(book);
	}


	

}
