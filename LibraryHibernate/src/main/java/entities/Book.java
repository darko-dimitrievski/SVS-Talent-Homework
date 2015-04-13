package entities;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book extends Publication {

	@Column(name = "isbn", unique = true)
	private String isbn;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
