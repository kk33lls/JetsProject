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

		//		fleet.add(addNewJet());
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
	
//	public void addNewJet() {
		//FIXME configure return
//		return jet;
		
//	}
	
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
			System.out.println("====== Fastest Jet ======");
			System.out.println(fastestJet);
		}
}
