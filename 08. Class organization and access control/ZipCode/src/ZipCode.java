public class ZipCode {
	public static void main(String[] args) {
		String zipCode = "312331dad4as11";
		int countDigit = 0;
		for (Character c : zipCode.toCharArray()) {
			if (Character.isDigit(c))
				countDigit++;
		}

		if (countDigit == 5 || countDigit == 9) {
			System.out.println("The zip has a five or nine-digits ");
		} else {
			System.out.println("The zip doesn't have five or nine-digits ");
		}
	}

}
