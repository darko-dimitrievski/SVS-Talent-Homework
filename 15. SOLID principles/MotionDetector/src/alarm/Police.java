package alarm;

public class Police implements Alarm {

	@Override
	public void alert() {
		System.out.println("The police is coming");
	}

}
