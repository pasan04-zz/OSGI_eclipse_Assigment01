package com.sa.osgi.restaurantadmin.Impl;

import java.util.Scanner;

import com.dsa.osgi.restaurantserviceresturant.RestaurantService;
import com.mtit.osgi.restaturantservicerestaurant.Impl.RestaurantServiceImpl;
import com.sa.restaurantadmin.admin.RestaurnatAdmin;

public class RestaurantAdminServices implements RestaurnatAdmin {
	
	@Override
	public void addFoodItems() {
		// TODO Auto-generated method stub	
		String[] foodsName = new String[5];
		double[] foodprice = new double[5];
		String  food = null;
		Scanner myscanner = new Scanner(System.in);
		System.out.print("Please enter the food Item name(If no, please enter NO) :");
		food = myscanner.nextLine();
		System.out.print("Enter the selling price of "+food +" :");
		double price = myscanner.nextDouble();
		System.out.println("Successfully added...\n");	
		int i =-1;	
		while(!food.equalsIgnoreCase("NO") && i<=5) {
			i++;
			if(i<=4) {
				foodsName[i] = food;
				foodprice[i] = price;
				System.out.print("Please enter the food Item name(If no, please enter NO) :");
				food = myscanner.next();
				if(!food.equalsIgnoreCase("NO")) {
					System.out.print("Enter the selling price of "+food +" :");
					price = myscanner.nextDouble();
					System.out.println("Successfully added...\n");		
				}
			}
			else {
				System.out.println("Sorry!,You have entered maximum food items !");
				food = "NO";
			}	
		}
		RestaurantService restService = new RestaurantServiceImpl();
		int j=0;
		while(j<foodsName.length) {
			restService.getFoodItems(foodsName[j],foodprice[j]);	
			j++;
		}
		System.out.println("=========== Your Food Item List ===========");
		restService.displayFoodItems();
		
	}

	@Override
	public void priceChanging() {
		// TODO Auto-generated method stub

		Scanner myscanner = new Scanner(System.in);
		System.out.println("==== Your Food List ====");
		RestaurantService restService = new RestaurantServiceImpl();
		restService.displayFoodItems();
		System.out.print(" Select the item that you want to price changing(Enter the number) :");
		int number = myscanner.nextInt();
		
		
		
	}

	
	
	
}
