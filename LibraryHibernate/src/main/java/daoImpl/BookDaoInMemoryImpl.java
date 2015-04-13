package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import entities.Book;

public class BookDaoInMemoryImpl implements BookDao {

	ArrayList<Book> books = new ArrayList<Book>();
	
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		books.add(book);
	}

	public List<Book> listAllBooks() {
		// TODO Auto-generated method stub
		return books;
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		
	}

}
