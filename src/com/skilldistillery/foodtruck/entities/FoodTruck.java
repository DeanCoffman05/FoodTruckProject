package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int currentNumberOfFoodTrucks = 0; // start at a starting value
	private int id;
	private String name;
	private String foodType;
	private int numRating;
	
	

	public FoodTruck(String name, String foodType, int numRating) {
		super();
		this.id = currentNumberOfFoodTrucks;
		this.name = name;
		this.foodType = foodType;
		this.numRating = numRating;
		this.currentNumberOfFoodTrucks++;
	}


	public static int getCurrentNumberOfFoodTrucks() {
		return currentNumberOfFoodTrucks;
	}

	public static void setCurrentNumberOfFoodTrucks(int currentNumberOfFoodTrucks) {
		FoodTruck.currentNumberOfFoodTrucks = currentNumberOfFoodTrucks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
@Override
	public String toString() {
		return "FoodTruck ID " + getId() + ", Truck Name " + getName() + ", Truck Type " + getFoodType()
				+ " Truck Rating " + getNumRating();
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getNumRating() {
		return numRating;
	}

	public void setNumRating(int numRating) {
		this.numRating = numRating;
	}

}
