package com.seavus.aliexpress.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	private int id;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String TranscationBill;
	@Column
	private Date validThru;
	@Column
	private String CVNNumber;
	@Column 
	private String name;
	@Column
	private String surname;
	@Column
	private Date DOB;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTranscationBill() {
		return TranscationBill;
	}

	public void setTranscationBill(String transcationBill) {
		TranscationBill = transcationBill;
	}

	public Date getValidThru() {
		return validThru;
	}

	public void setValidThru(Date validThru) {
		this.validThru = validThru;
	}

	public String getCVNNumber() {
		return CVNNumber;
	}

	public void setCVNNumber(String cVNNumber) {
		CVNNumber = cVNNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	
}
