package acme.adapters;

import acme.heater.AcmeHeaterAdapter;
import acme.thermometer.AcmeThermometerAdapter;
import acme.thermoregulator.AcmeEfficientThermoregulator;
import acme.thermoregulator.AcmeStandardThermoregulator;
import acme.thermoregulator.AcmeThermoregulator;

import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class AcmeStandardThermoregulatorAdapter implements VentoThermoregulator {

	private AcmeStandardThermoregulator acmeStandardThermoregulator;
	private Thread thread;

	public AcmeStandardThermoregulatorAdapter(VentoThermometer thermometer,
			VentoHeater heater) {
		AcmeHeaterAdapter ventoHeater = new AcmeHeaterAdapter(heater);
		AcmeThermometerAdapter ventoThermometer = new AcmeThermometerAdapter(
				thermometer);
		this.acmeStandardThermoregulator = new AcmeStandardThermoregulator(
				ventoThermometer, ventoHeater);
		thread = new Thread(acmeStandardThermoregulator);
	}

	@Override
	public void enablePower() {
		// TODO Auto-generated method stub
		acmeStandardThermoregulator.turnPowerOn();
		thread.start();
	}

	@Override
	public void disablePower() {
		// TODO Auto-generated method stub
		acmeStandardThermoregulator.turnPowerOff();
		thread.interrupt();
	}

	@Override
	public void setTemperature(Integer temperature) {
		// TODO Auto-generated method stub
		acmeStandardThermoregulator.setThermoregulatorTemperature(temperature);
	}

}
