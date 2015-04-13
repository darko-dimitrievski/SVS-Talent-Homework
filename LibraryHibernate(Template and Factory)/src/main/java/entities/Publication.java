package entities;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "publication")
@Inheritance(strategy = InheritanceType.JOINED)
public class Publication{

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "title")
	private String title;

	@OneToMany(mappedBy = "publication")
	private Set<Loan> loans;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
