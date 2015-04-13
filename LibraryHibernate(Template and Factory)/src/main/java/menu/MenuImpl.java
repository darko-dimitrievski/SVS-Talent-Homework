package menu;

import java.util.Scanner;

import entities.Book;
import factoryDao.FactoryDao;
import service.LibraryServiceImpl;

public class MenuImpl {
	
	LibraryServiceImpl libraryServiceImpl;
	Scanner scanner;
	
	

	public void startMenu() {
		// TODO Auto-generated constructor stub
		libraryServiceImpl = new LibraryServiceImpl();
		System.out.println("Insert 1 for HibernateDAOImpl");
		System.out.println("Insert 2 for JDBCDAOImpl");
		System.out.println("Insert 3 for InMemoryDAOImpl");
		scanner = new Scanner(System.in);
		libraryServiceImpl.bookDaoImpl = FactoryDao.chooseDaoImpl(scanner.nextInt());
		//Bad menu implementation :)
		Book book = new Book();
		book.setIsbn("666");
		book.setTitle("Midnight Train");
		libraryServiceImpl.addBook(book);
	}
	
	
}
