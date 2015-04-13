package acme.thermometer;

import com.ventoelectrics.waterheater.VentoThermometer;

public class AcmeThermometerAdapter implements AcmeThermometer {

	private VentoThermometer thermometer;

	public AcmeThermometerAdapter(VentoThermometer thermometer) {
		this.thermometer = thermometer;
	}

	@Override
	public int getTemperature() {
		// TODO Auto-generated method stub
		return thermometer.getTemperature();
	}

}
