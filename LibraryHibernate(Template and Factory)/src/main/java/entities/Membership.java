package entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="membership")
public class Membership {
	
	@Id
	@GeneratedValue
	private int id;
	private Date startDate;
	private Date endDate;
	private String membershiptype;
	
	@OneToOne
	private Member member;
	
	public Membership(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMembershiptype() {
		return membershiptype;
	}

	public void setMembershiptype(String membershiptype) {
		this.membershiptype = membershiptype;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
	
	
	

}
