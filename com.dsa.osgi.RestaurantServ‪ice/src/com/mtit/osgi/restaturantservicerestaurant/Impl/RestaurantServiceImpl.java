package com.mtit.osgi.restaturantservicerestaurant.Impl;


import java.util.Scanner;

import com.dsa.osgi.restaurantserviceresturant.*;

public class RestaurantServiceImpl implements RestaurantService {
	

	@Override
	public void DisplayMenuList() {
		// TODO Auto-generated method stub	
		System.out.println("===== Meal Time =====");
		System.out.println("=====1.Breakfast ====");
		System.out.println("=====2.Lunch  =======");		
		System.out.println("=====3.Dinner  ======");	
	}

	@Override
	public void selectMealType(int type) {
		// TODO Auto-generated method stub
		if(type == 1) {
			System.out.println(" ");
			System.out.println("These are available for breakfast");
			System.out.println("==== 1. StringHoppers =>  1pc = Rs. 15.00");
			System.out.println("==== 2. Rice and Curry => 1pc = Rs. 200.00");
			System.out.println("==== 3. Bread =====> 1pc = Rs. 150.00");
			System.out.println("==== 4. Roti ======> 1pc = Rs. 100.00");
			
		
		}
		else if(type ==2) {
			System.out.println(" ");
			System.out.println("These are available for lunch");
			System.out.println("===== 1. Rice and Curry ===");
			System.out.println("===== 2. Fried Rice =======");
			System.out.println("===== 3. Noodles ==========" );
			
			
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
	
	
	 
}
