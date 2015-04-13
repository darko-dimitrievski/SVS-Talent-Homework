package com.seavus.webcalculator;

public class CalculatorImpl implements Calculator {

	public int add(int number1, int number2) {
		// TODO Auto-generated method stub
		return Math.addExact(number1, number2);
	}

	public int substract(int number1, int number2) {
		// TODO Auto-generated method stub
		return Math.subtractExact(number1, number2);
	}
}
