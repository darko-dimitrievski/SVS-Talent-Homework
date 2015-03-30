public class BusinessLogic {
	BookDao bookDao = new BookDao();

	public void addBook(String isbn, String title) {
		bookDao.addBook(isbn, title);
	}

	public void listAllBooks() {
		bookDao.listAllBooks();
	}
	
	public void updateBook(String isbn,String title){
		bookDao.updateBook(isbn, title);
	}
	
	public void deleteBook(String isbn){
		bookDao.deleteBook(isbn);
	}
}
