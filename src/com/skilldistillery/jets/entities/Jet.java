package com.skilldistillery.jets.entities;

public abstract class Jet {
	
	private String model;
	private long speed;
	private long range;
	private long price;

	public void fly() {
		System.out.println("The " + model + " is flying at " + speed + " miles per second!!");
		//fly() prints out the model, speed (in MPH), range, and price and the amount of time 
		//the jet can fly until it runs out of fuel (based on speed and range).
	}

	public Jet(String model, long speed, long range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public long getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet [model: ").append(model).append(", speed: ").append(speed).append(" miles per second" ).append(", range: ").append(range)
				.append(", price: ").append(price).append("]");
		return builder.toString();
	}
	
	
}
