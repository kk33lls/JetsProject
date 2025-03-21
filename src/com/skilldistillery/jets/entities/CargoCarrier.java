package com.skilldistillery.jets.entities;

public class CargoCarrier extends Jet implements CargoCarrierInterface{

	public CargoCarrier(String model, long speed, long range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void loadCargo() {
		
	}

}
