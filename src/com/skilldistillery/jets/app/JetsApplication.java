package com.skilldistillery.jets.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JetsApplication {
	  //Airfield/Scanner declaration, initialization, and instantiation
	private AirField airField = new AirField();
	private static Scanner sc;

	public static void main(String[] args) {
		//JetsApplication instance 
		JetsApplication app = new JetsApplication();
		app.launch();
	}
	
	public void launch() {
		sc = new Scanner(System.in);
		boolean isTrue = true;
		do {
			displayUserMenu();
			String userChoice = sc.next();
			sc.nextLine();
			switch(userChoice){
			case "1": 
				airField.listFleet();
				break;
			case "2":
				airField.flyInAirfield();
				break;
			case "3":
				airField.printFastestJet();
				break;
			case "4":
				airField.printLongestRange();
				break;
			case "5":
				airField.loadCargoOnAirfield();
				break;
			case "6":
				airField.sendFighterJets();
				break;
			case "7":
				System.out.println("What kind of aircraft would you like to add? Fighter jet, cargo, or passenger?");
				try {
					String reply = sc.nextLine();
					reply.toLowerCase();
					switch (reply) {
					// FIXME fighter jet not working, try/catch is not working
					case "fighter jet":
						System.out.println("Please enter the model: ");
						String model = sc.next();
						System.out.println("Please enter the speed: ");
						long speed = sc.nextLong();
						System.out.println("Please enter the range: ");
						long range = sc.nextLong();
						System.out.println("Please enter the price: ");
						long price = sc.nextLong();
						airField.addFighterJet(model, speed, range, price);
						break;
					case "cargo":
						System.out.println("Please enter the model: ");
						String model1 = sc.next();
						System.out.println("Please enter the speed: ");
						long speed1 = sc.nextLong();
						System.out.println("Please enter the range: ");
						long range1 = sc.nextLong();
						System.out.println("Please enter the price: ");
						long price1 = sc.nextLong();
						airField.addCargoCarrier(model1, speed1, range1, price1);
						break;
					case "passenger":
						System.out.println("Please enter the model: ");
						String model2 = sc.next();
						System.out.println("Please enter the speed: ");
						long speed2 = sc.nextLong();
						System.out.println("Please enter the range: ");
						long range2 = sc.nextLong();
						System.out.println("Please enter the price: ");
						long price2 = sc.nextLong();
						airField.addPassengerPlane(model2, speed2, range2, price2);
						break;
					default:
						System.out.println("Invalid input try again.");
						break;
					}
				} catch (InputMismatchException e) {
					System.err.println(e);
				}
				break;
			case "8":
				airField.removalList();
				System.out.println("Which jet would you like to remove? Enter the assigned number");
				int removeOption = sc.nextInt();
				airField.removeJet(removeOption);
				break;
			case "9":
				
				System.out.println("Time to jet, catch you on the next runway!" + "\u2708");
				isTrue = false;
				break;
				default:
					System.out.println("Inavlid input, try again!");
					
			}
			
		} while(isTrue);
		sc.close();
	}
	public void displayUserMenu() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~ Welcome to the airfield! ~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("     please select a menu item by typing in the assigned number      ");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View the fastest jet");
		System.out.println("4. View the jet with longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Send the Fighter Jets");
		System.out.println("7. Add a jet to the fleet");
		System.out.println("8. Remove a jet from the fleet");
		System.out.println("9. Quit");
	}
	
}
