package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private FoodTruck[] fleet = new FoodTruck[5];
	Scanner sc = new Scanner(System.in);
	private	int currentNumberOfFoodTrucks = 0;
	

	public static void main(String[] args) {
		FoodTruckApp application = new FoodTruckApp();

		application.run(application.fleet);
	}

	public void run(FoodTruck[] fleet) {
	   
		if (currentNumberOfFoodTrucks < 5) {
		for (int i = 0; i < 5; i++) {
	        System.out.println("Welcome to the Food Truck Application! ");
	        System.out.println("Please enter the Name of your Food Truck, type of food they serve, and a number from 1 to 5 to rate the truck.");
	        System.out.println("You may only enter up to 5 food trucks.");
	        System.out.println();

	            System.out.println("Please enter the Name of this Truck or type quit to exit: ");
	            String name = sc.nextLine();
	            System.out.println();
	            if (name.equalsIgnoreCase("quit")) {
	                System.out.println("You selected quit.");
	                showMenu(fleet);
	                break;
	            }
	            
	            System.out.print("Please enter the rating of 1 to 5 for this food truck: ");
	            System.out.println();
	            if (!sc.hasNextInt()) {
	                System.out.println("Invalid input. Please enter an integer for the rating.");
	                sc.nextLine();
	                sc.nextLine();
	            } else {
	                int numRating = sc.nextInt();
	                if (numRating < 1 || numRating > 5) {
	                    System.out.println("Invalid input!");
	                    sc.nextLine();
	                } else {
	                    sc.nextLine(); 
	                    System.out.println("Please enter the food type of this truck:  ");
	                    System.out.println();
	                    String foodType = sc.nextLine();
	                    fleet[i] = new FoodTruck(name, foodType, numRating);
	                    currentNumberOfFoodTrucks++;
	                 System.out.println(currentNumberOfFoodTrucks);
	                 run(fleet);
	                }
	            }
	    } 
	    
	         
	    }
		else {
			System.out.println();
			System.out.println("I'm sorry this exceeds the max number of trucks");
	    }
	

}

	public void showMenu(FoodTruck[] fleet) {

		System.out.println(" Welcome to the Options Menu");
		System.out.println(" Please use the corresponding to select a menu option.");
		System.out.println(" 1. List all existing food trucks.");
		System.out.println(" 2. See the  average rating of food trucks.");
		System.out.println(" 3. Display the highest-rated food truck.");
		System.out.println(" 4. Quit the program.");

		String menuSelection = sc.nextLine();
		if (menuSelection.equals("1")) {
			arrayCheck(fleet);
			showMenu(fleet);
			;

		} else if (menuSelection.equals("2")) {
			aveAll(fleet);
		} else if (menuSelection.equals("3")) {
			highestRating(fleet);
		} else if (menuSelection.equals("4")) {
			exitAll(fleet);
		} else {
			System.out.println("Invalid Selection Please select again. ");
		}
	}

	public void arrayCheck(FoodTruck[] fleet) {
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null) {
				System.out.println(fleet[i]);
				System.out.println();
			} else {
				break;
			}
		}
	}

	public void aveAll(FoodTruck[] fleet) {
		double total = 0;
		double average = 0;
		double holder = 0;
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null) {
				total =+ fleet[i].getNumRating();
				holder = i + 1;
			}
			average = total / holder;
		}
		System.out.println("The average rating of your fleet is:  " + average);
		showMenu(fleet);

	}

	public void highestRating(FoodTruck[] fleet) {
		double holdRating = fleet[0].getNumRating();
		int hold = 0;
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null) {
				if (fleet[i].getNumRating() > holdRating) {
					holdRating = fleet[i].getNumRating();
					hold = i;
				}
			}
		}
		System.out.println(
				"The highest rated truck is: " + fleet[hold].getName() + " with a rating of " + holdRating + "\n");
		showMenu(fleet);
	}

	public void exitAll(FoodTruck[] fleet) {
		System.out.println("Thank you. Exit Program");
		System.out.println(" ");
	}
}