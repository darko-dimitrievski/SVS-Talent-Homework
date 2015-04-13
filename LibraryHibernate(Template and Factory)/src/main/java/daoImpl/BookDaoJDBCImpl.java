package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcTemplate.JDBCReader;
import jdbcTemplate.JDBCTemplate;
import jdbcTemplate.JDBCWriter;
import dao.BookDao;
import entities.Book;

public class BookDaoJDBCImpl implements BookDao {

	public void addBook(final Book book) {
		// TODO Auto-generated method stub
		new JDBCTemplate().executeQuery(new JDBCWriter() {
			
			public void insertQuery(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into book (isbn, title) values (?, ?)");
				preparedStatement.setString(1, book.getIsbn()) ;
				preparedStatement.setString(2, book.getTitle());
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}
		});
	}

	public List<Book> listAllBooks() {
		// TODO Auto-generated method stub
		return new JDBCTemplate().returnQuery(new JDBCReader() {
			
			public ArrayList<Book> returnQuery(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				ArrayList<Book> books = new ArrayList<Book>();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM book");
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Book book = new Book();
					book.setIsbn(resultSet.getString("isbn"));
					book.setTitle(resultSet.getString("title"));

					books.add(book);
				}
				preparedStatement.close();
				return books;
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
