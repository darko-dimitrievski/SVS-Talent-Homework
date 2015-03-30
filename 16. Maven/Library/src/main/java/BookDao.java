import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDao {
	Connection connection;

	public void addBook(String isbn, String title) {
		Connection connection = connectToDatabase();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into book (isbn, title) values (?, ?)");
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, title);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listAllBooks() {
		Connection connection = connectToDatabase();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from book");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String isbn = resultSet.getString("isbn");
				String title = resultSet.getString("title");
				System.out.println(id + " | " + isbn + " | " + title);

			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public Connection connectToDatabase() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/library", "postgres",
					"postgres");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void updateBook(String isbn, String title) {
		Connection connection = connectToDatabase();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE BOOK SET TITLE = ? "
							+ " WHERE ISBN = ?");
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, isbn);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBook(String isbn) {
		Connection connection = connectToDatabase();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM BOOK WHERE ISBN = ?");
			preparedStatement.setString(1, isbn);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
