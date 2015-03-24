import java.util.StringTokenizer;

public class DateParser {
	public static void main(String[] args) {

		String datum = "23/03/1992";
		StringTokenizer st1 = new StringTokenizer(datum, "/");
		System.out.println(st1.nextToken());
		System.out.println(st1.nextToken());
		System.out.println(st1.nextToken());
		System.out.println("==========");
		String[] parts = datum.split("/");
		System.out.println(parts[0] + "\n" + parts[1] + "\n" + parts[2]);
		
		
	}

}
