import java.util.ArrayList;

public class YearlyCalendar {

	public static void main(String[] args) {
		int year = 2010;
		ArrayList<String> denovi;
		if (prestapnaGodina(year)) {
			denovi = new ArrayList<String>(366);
		} else {
			denovi = new ArrayList<String>(365);
		}
		for (int month = 1; month <= 12; month++) {
			int daysInMonth = 0;
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				daysInMonth = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				daysInMonth = 30;
				break;
			case 2:
				if (prestapnaGodina(year))
					daysInMonth = 29;
				else
					daysInMonth = 28;
				break;

			}
			for (int days = 1; days <= daysInMonth; days++) {
				denovi.add(days + "." + month + "." + year);
			}
		}
		for (int i = 0; i < denovi.size(); i++) {
			System.out.println(denovi.get(i));
		}
	}

	static boolean prestapnaGodina(int year) {
		int count = 0;
		if (year % 4 == 0) {
			count = 29;
		} else {
			count = 28;
		}
		if ((year % 100 == 0) & (year % 400 != 0)) {
			count = 28;
		}
		if (count == 29)
			return true;
		else
			return false;
	}
}
