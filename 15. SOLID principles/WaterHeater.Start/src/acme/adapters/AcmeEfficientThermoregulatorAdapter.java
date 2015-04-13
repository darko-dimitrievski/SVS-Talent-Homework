package acme.adapters;

import acme.heater.AcmeHeaterAdapter;
import acme.thermometer.AcmeThermometerAdapter;
import acme.thermoregulator.AcmeEfficientThermoregulator;

import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class AcmeEfficientThermoregulatorAdapter implements
		VentoThermoregulator {

	private AcmeEfficientThermoregulator acmeEfficientthermoregulator;
	Thread thread;

	public AcmeEfficientThermoregulatorAdapter(VentoThermometer thermometer,
			VentoHeater heater) {
		AcmeHeaterAdapter ventoHeater = new AcmeHeaterAdapter(heater);
		AcmeThermometerAdapter ventoThermometer = new AcmeThermometerAdapter(
				thermometer);
		this.acmeEfficientthermoregulator = new AcmeEfficientThermoregulator(
				ventoThermometer, ventoHeater);
		thread = new Thread(acmeEfficientthermoregulator);
	}

	@Override
	public void enablePower() {
		// TODO Auto-generated method stub
		acmeEfficientthermoregulator.turnPowerOn();
		thread.start();
	}

	@Override
	public void disablePower() {
		// TODO Auto-generated method stub
		acmeEfficientthermoregulator.turnPowerOff();
		thread.start();
	}

	@Override
	public void setTemperature(Integer temperature) {
		// TODO Auto-generated method stub
		acmeEfficientthermoregulator.setThermoregulatorTemperature(temperature);
	}

}
