package com.seavus.aliexpress.exceptions;


public class OutOfProduct extends Exception {
	public OutOfProduct() {
		// TODO Auto-generated constructor stub
		super("We don't have so much articles of that product in the warehouse. We are sorry");
	}
}
