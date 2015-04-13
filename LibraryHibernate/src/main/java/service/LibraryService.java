package service;

import java.util.List;

import entities.Book;
import entities.Publication;

public interface LibraryService {
	public void addBook(final Book book);
	public List<Book> listAllBooks();
	public void updateBook(final Book book);
	public void deleteBook(final Book book);
}
