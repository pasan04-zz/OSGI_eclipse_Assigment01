package com.dsa.osgi.restaurantserviceresturant;

public interface RestaurantService {
	 
	   public void DisplayMenuList();
	   public void selectMealType(int type);
	   public void displaycalculatingDetails(); //This is used to display the common calculating details 
	   public double calculateBreakfastPrice();
	   public double calculateLunchPrice();
	   public double calculateDinnerPrice();
	   public void getFoodItems(String foodsName,double price);
	   public void displayFoodItems();
	   public double calculateFoodPrice(int foodNo,int quantity);
	   public void orderedList();
	   public void printBill();
	 
}
