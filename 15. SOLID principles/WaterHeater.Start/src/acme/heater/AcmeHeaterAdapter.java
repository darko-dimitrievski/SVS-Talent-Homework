package acme.heater;

import com.ventoelectrics.waterheater.VentoHeater;

public class AcmeHeaterAdapter implements AcmeHeater{
	
	public VentoHeater heater;
	
	public AcmeHeaterAdapter(VentoHeater heater) {
		// TODO Auto-generated constructor stub
		this.heater=heater;
	}

	@Override
	public void turnHeaterOn() {
		// TODO Auto-generated method stub
		heater.enable();
	}

	@Override
	public void turnHeaterOff() {
		// TODO Auto-generated method stub
		heater.disable();
	}

}
