package entities;

import javax.persistence.*;

@Entity
@Table(name = "magazine")
public class Magazine extends Publication {

	@Column(name = "issn", unique=true)
	private String issn;

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}
}
