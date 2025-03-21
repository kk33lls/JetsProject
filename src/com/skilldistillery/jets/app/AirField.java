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
			   
				 System.out.println(line);
			    
			    String[] field = line.split(", ");
			    
			    String model = field[1];
			    double speed = Double.parseDouble(field[2]);
			    int range = Integer.parseInt(field[3]);
			    long price = Long.parseLong(field[4]);
			    
			    switch(field[0]) {
			    case "P":
			    	Jet passengerJet = new JetImpl(model, speed, range, price);
			    	break;
			    case "F": 
			    	Jet fighterJet = new FighterJet(model, speed, range, price);
			    	break;
			    case "C":
			    	Jet cargoCarrier = new CargoCarrier(model, speed, range, price);
			    	break;
			    }
			  }
			}
			catch (IOException e) {
			  System.err.println(e);
			}
	}
	
//	public Jet addNewJet() {
		//FIXME configure return
//		return jet;
		
//	}
}
