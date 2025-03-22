package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;

public class AirField {
	
	private List<Jet> fleet = new ArrayList<>();
	
	public AirField() {
		loadJetsFromFile("jetData.txt");
	}
	
	public void loadJetsFromFile(String fileName) {
		
		try ( BufferedReader bufIn = new BufferedReader(new FileReader(fileName)) ) {
			  String line;
			  
			  while ((line = bufIn.readLine()) != null) {
			    
			    String[] field = line.split(", ");
			    
			    String model = field[1];
			    long speed = Long.parseLong(field[2]);
			    long range = Long.parseLong(field[3]);
			    long price = Long.parseLong(field[4]);
			    
			    switch(field[0]) {
			    case "P":
			    	Jet passengerJet = new JetImpl(model, speed, range, price);
			    	fleet.add(passengerJet);
			    	break;
			    case "F": 
			    	Jet fighterJet = new FighterJet(model, speed, range, price);
			    	fleet.add(fighterJet);
			    	break;
			    case "C":
			    	Jet cargoCarrier = new CargoCarrier(model, speed, range, price);
			    	fleet.add(cargoCarrier);
			    	break;
			    }
			  }
			}
			catch (IOException e) {
			  System.err.println(e);
			}
	}
	
	
	public void listFleet() {
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println(fleet.get(i));
		}
	}

	public void flyInAirfield() {
		for (int i = 0; i < fleet.size(); i++) {
			fleet.get(i).fly();
		}
	}
	
	public void printFastestJet() {
			Jet fastestJet = fleet.get(0);
			for(Jet j : fleet) {
				if(j.getSpeed() > fastestJet.getSpeed()) {
					fastestJet = j;
				}
			}
			System.out.println("============= Fastest Jet =============");
			System.out.println(fastestJet);
		}
	
	public void printLongestRange() {
		Jet longestRange = fleet.get(0);
		for(Jet j : fleet) {
			if(j.getRange() > longestRange.getRange()) {
				longestRange = j;
			}
		}
		System.out.println("============= Jet with the Longest Range =============");
		System.out.println(longestRange);
	}
	
	public void loadCargoOnAirfield() {
		for (Jet jet1 : fleet) {
			if(jet1 instanceof CargoCarrier) {
				CargoCarrier loadCargoDowncast = (CargoCarrier) jet1;
				System.out.println(loadCargoDowncast + " is getting loaded!");
				loadCargoDowncast.loadCargo();
			}
		}
	}
	
	public void sendFighterJets() {
		for (Jet jet : fleet) {
		if(jet instanceof FighterJet) {
				FighterJet fighterJetDowncast = (FighterJet) jet;
				System.out.println(fighterJetDowncast + " is off to fight!");
				fighterJetDowncast.fight();
			}
		}
	}
	
	public void addFighterJet(String model, long speed, long range, long price) {
		Jet fighterJet = new FighterJet(model, speed, range, price);
    	fleet.add(fighterJet);
    	System.out.println("Your " + model + " has been added to the fleet!");
	}
	
	public void addCargoCarrier(String model, long speed, long range, long price) {
		Jet cargoCarrier = new CargoCarrier(model, speed, range, price);
    	fleet.add(cargoCarrier);
    	System.out.println("Your " + model + " has been added to the fleet!");
	}
	
	public void addPassengerPlane(String model, long speed, long range, long price) {
		Jet passengerJet = new JetImpl(model, speed, range, price);
    	fleet.add(passengerJet);
    	System.out.println("Your " + model + " has been added to the fleet!");
	}
	public void removalList() {
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println((i + 1) + ": " + fleet.get(i));
		}
	}

	public void removeJet(int removeOption) {
		try {
				fleet.remove(removeOption - 1);
				System.out.println(removeOption + " has been removed!");

		} catch (Exception e) {
			System.err.println(e);
		}
	}
}



