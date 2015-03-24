
public class ZipCodeWithExceptions {
	public static void main(String[] args) {
		ZipCode zip;
		try {
			zip = new ZipCode("31131133");
		} catch (InvalidZipCode e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
