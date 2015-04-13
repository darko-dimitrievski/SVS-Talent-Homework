package dao;

import java.util.List;

import entities.Book;

public interface BookDao {
	public void addBook(final Book book);
	public List<Book> listAllBooks();
	public void updateBook(final Book book);
	public void deleteBook(final Book book);
}
