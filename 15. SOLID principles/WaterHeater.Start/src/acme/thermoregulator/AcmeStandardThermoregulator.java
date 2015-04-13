package acme.thermoregulator;

import java.util.concurrent.TimeUnit;

import acme.heater.AcmeHeater;
import acme.thermometer.AcmeThermometer;

public class AcmeStandardThermoregulator implements AcmeThermoregulator,
		Runnable {
	Boolean powerOn;
	AcmeThermometer thermometer;
	AcmeHeater heater;
	int thermoregulatorTemperature;
	int thermometerTemperature;

	public AcmeStandardThermoregulator(AcmeThermometer thermometer,
			AcmeHeater heater) {
		this.thermometer = thermometer;
		this.heater = heater;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (powerOn) { // dodeka e vklucen thermoregulatorot
			try {
				TimeUnit.SECONDS.sleep(3);
				if (thermometerTemperature > thermoregulatorTemperature) {
					heater.turnHeaterOff();
				} else {
					heater.turnHeaterOn();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setThermoregulatorTemperature(int temperature) {
		// TODO Auto-generated method stub
		this.thermoregulatorTemperature = temperature;
	}

	@Override
	public void turnPowerOff() {
		// TODO Auto-generated method stub
		powerOn = false;
	}

	@Override
	public void turnPowerOn() {
		// TODO Auto-generated method stub
		powerOn = true;
	}
}
