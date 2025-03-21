package com.skilldistillery.jets.app;

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
			switch(userChoice){
			case "1": 
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				break;
			case "9":
				System.out.println("Time to jet, catch you on the next runway!" + "\u2708");
				isTrue = false;
				break;
				default:
					System.out.println("Inavlid input, try again!");
					
			}
			//switch on user choice
			//call an airfield method to act on user choice
		} while(isTrue);
		
		sc.close();
	}
	public void displayUserMenu() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~ Welcome to the airfield! ~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("     please select a menu item by putting in the assigned number      ");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Send the Fighter Jets");
		System.out.println("7. Add a jet to the fleet");
		System.out.println("8. Remove a jet from the fleet");
		System.out.println("9. Quit");
	}
}
