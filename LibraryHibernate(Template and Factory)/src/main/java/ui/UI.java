package ui;

import java.util.Scanner;

public class UI {
	private Scanner input;

	public UI() {
		input = new Scanner(System.in);
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}
}
