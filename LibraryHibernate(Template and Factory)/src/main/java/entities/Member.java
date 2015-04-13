package entities;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "email")
	private String email;
	@Column(name = "name")
	private String name;

	@OneToOne(mappedBy = "member")
	private Membership membership;

	@OneToMany(mappedBy = "member")
  	private Set<Loan> loans;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
