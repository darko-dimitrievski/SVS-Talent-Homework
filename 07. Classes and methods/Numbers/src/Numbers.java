import java.util.ArrayList;

public class Numbers {
	public static void main(String[] args) {
		ArrayList<String> broevi = new ArrayList<String>();
		if (args.length > 0) {
			for (String s : args) {
				broevi.add(s);
			}
		}
		int vkupno = 0;
		int count = 1;
		for (String s : broevi) {
			switch (s) {
			case "one":
				vkupno += 1 * Math.pow(10, broevi.size() - count);
				count++;
				break;
			case "two":
				vkupno += 2 * Math.pow(10, broevi.size() - count);
				count++;
				break;
			case "three":
				vkupno += 3 * Math.pow(10, broevi.size() - count);
				count++;
				break;
			case "four":
				vkupno += 4 * Math.pow(10, broevi.size() - count);
				count++;
				break;
			case "five":
				vkupno += 5 * Math.pow(10, broevi.size() - count);
				count++;
				break;
			case "six":
				vkupno += 6 * Math.pow(10, broevi.size() - count);
				count++;
				break;
			case "seven":
				vkupno += 7 * Math.pow(10, broevi.size() - count);
				count++;
				break;
			case "eight":
				vkupno += 8 * Math.pow(10, broevi.size() - count);
				count++;
				break;
			case "nine":
				vkupno += 9 * Math.pow(10, broevi.size() - count);
				count++;
				break;
			case "zero":
				vkupno += 0 * Math.pow(10, broevi.size() - count);
				count++;
				break;
			}
		}
		System.out.println(vkupno);
	}
}
