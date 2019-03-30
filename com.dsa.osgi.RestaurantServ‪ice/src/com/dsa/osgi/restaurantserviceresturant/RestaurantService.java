package com.dsa.osgi.restaurantserviceresturant;

public interface RestaurantService {
	 
	   public void DisplayMenuList();
	   public void displaycalculatingDetails(); //This is used to display the common calculating details 
	   public void getFoodItems(String foodsName,double price);
	   public void displayFoodItems();
	   public double calculateFoodPrice(int foodNo,int quantity);
	   public void orderedList();
	   public void printBill();
	   public void receiveCustomerName(String Name);
	   public boolean priceChangingInterface(int number,double newprice);
//	   public void gettingNewPrice(double newprice);
	 
}
