
public class ZipCode {
	String zipCode;

	public ZipCode(String zipCode) throws InvalidZipCode {
		if (zipCode.toCharArray().length != 5
				&& zipCode.toCharArray().length != 9) {
			throw new InvalidZipCode();
		} else {
			this.zipCode = zipCode;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return zipCode;
	}
}
