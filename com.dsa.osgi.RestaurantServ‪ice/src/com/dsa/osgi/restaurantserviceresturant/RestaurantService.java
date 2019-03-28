package com.dsa.osgi.restaurantserviceresturant;

public interface RestaurantService {
	 
	   public void DisplayMenuList();
	   public void selectMealType(int type);
	   public void displaycalculatingDetails(); //This is used to display the common calculating details 
	   public double calculateBreakfastPrice();
	   public double calculateLunchPrice();
	   public double calculateDinnerPrice();

	   
	   
	 
}
