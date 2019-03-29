package com.mtit.osgi.restaturantservicerestaurant.Impl;




import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Scanner;

import com.dsa.osgi.restaurantserviceresturant.*;

public class RestaurantServiceImpl implements RestaurantService {
	

	@Override
	public void DisplayMenuList() {
		// TODO Auto-generated method stub	
		System.out.println("\n\n===== Meal Time =====");
		
	}

	@Override
	public void selectMealType(int type) {
		// TODO Auto-generated method stub
		
		if(type == 1) {
			System.out.println("\nThese are available for breakfast");
			RestaurantService rest = new RestaurantServiceImpl();
			rest.displayFoodItems();		
		
		}
		else if(type ==2) {
			System.out.println(" ");

			
			
		}
		else if(type ==3) {
			System.out.println(" ");
			System.out.println("These are available for dinner");
			System.out.println("1. Rice and Curry");
			System.out.println("2. Fried Rice ");
			System.out.println("3. Noodles" );
			System.out.println("4. Hoppers");
			System.out.println("5. Roti");
		}
	}
	

	@Override
	public double calculateBreakfastPrice() {
		// TODO Auto-generated method stub
		return 0;
		
		
		
	}

	@Override
	public double calculateLunchPrice() {
		// TODO Auto-generated method stub
		return 0;
		
		
		
	}

	@Override
	public double calculateDinnerPrice() {
		// TODO Auto-generated method stub
		return 0;
		
		
		
	}

	@Override
	public void displaycalculatingDetails() {
		// TODO Auto-generated method stub
		
		int i =1;
		double stringHopperPrice =15.0;
		double riceAndCurryPrice = 200.0;
		double breadprice = 150.0;
		double rotiprice = 100.0;
		Scanner myscanner = new Scanner(System.in);
		while(i != 0) {
			
			System.out.println("Enter the meal you want :");	
			int mealCategory = myscanner.nextInt();
			System.out.println("Enter the quantity you want :");
			int quantity = myscanner.nextInt();
			
			double totalPrice =0;
			if(mealCategory == 1) {
				
				totalPrice = totalPrice+quantity*stringHopperPrice;
			}
			
		}
			
		
	}
	
	
	static String arrayItems[] = new String[5];
	static double arrayItemsPrice[] = new double[5];
	static String orderedList[] = new String[20];
	static double quantityList[] = new double[20];
	static double priceList[] = new double[30];
	static int i =0,passingValues =0;
	@Override
	public void getFoodItems(String foodsName,double price) {
		// TODO Auto-generated method stub

			arrayItems[i] = foodsName;
			arrayItemsPrice[i] = price;
			i++;
	}
	@Override
	public void displayFoodItems() {
		// TODO Auto-generated method stub
		System.out.println("= Number ===    Item Name==              ====Price====   ");
		int j =0; 
		 while(j< 5) {
			 
			 if(arrayItems[j] == null) {
				 
				 System.out.println("  "+(j+1)+".          "+"Not Available"+"                 "+ arrayItemsPrice[j]+"   ");	
			 }
			 else {
				 
				 System.out.println("  "+(j+1)+".           "+arrayItems[j]+"                   "+ arrayItemsPrice[j]+"   "); 
			 }
			 
			 j++;
		 }	
	}

	static double totalPrice =0.0;
	static int orderfood =0;
	@Override
	public double calculateFoodPrice(int foodNo,int quantity) {
		// TODO Auto-generated method stub
		

		if(foodNo >5 && foodNo < 0) {
			
			System.out.println("Error!, Item range in between 1 to 5");
		}
		else if(quantity <0 ){
			
			System.out.println("Error!, Quantity must be greater than 0");
			
		}
		else if(quantity >10) {
			
			System.out.println("Can only provide maximum 10 items");
		}
		else {
			int actualFoodNo = foodNo -1;
			String foodName = arrayItems[actualFoodNo];
			double price = arrayItemsPrice[actualFoodNo];
			orderedList[orderfood] = foodName;
			quantityList[orderfood] = quantity;
			double quantityPrice = price*quantity;
			priceList[orderfood] = quantityPrice;
			totalPrice = totalPrice+quantityPrice;
			passingValues++;
			orderfood++;
			
//			System.out.println(foodName+"   ===============     " +quantityPrice);
			
		}
		return totalPrice;

	}

	@Override
	public void orderedList() {
		// TODO Auto-generated method stub
		int i =0;
		System.out.println("Item Name    " + "        Quantity   "+"    Price    ");
		while(i < passingValues) {
					
			System.out.println(orderedList[i]+"              "+ quantityList[i]+ "              "+priceList[i]);
			i++;
		}
		
		
	}
	

	
}
