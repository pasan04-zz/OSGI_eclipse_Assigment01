package com.sa.osgi.restaurantconsumer.Impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.dsa.osgi.restaurantservice.utils.RestaurantUtils;
import com.dsa.osgi.restaurantservice.utils.TableQueue;
import com.dsa.osgi.restaurantserviceresturant.RestaurantService;
import com.mtit.osgi.restaturantservicerestaurant.Impl.RestaurantServiceImpl;
import com.sa.osgi.restaurantconsumer.consumer.RestaurantConsumer;

public class RestaurantConsumerServices implements RestaurantConsumer{

	@Override
	public void allocatingTable() {
		// TODO Auto-generated method stub
		
		
        Scanner myscanner = new Scanner(System.in);
        int intialstate = 1;
        int noOfTables = 4;
        
        //creating an object from Tablequeue inorder to check the availabity of the table in the restaurant
        TableQueue table = new TableQueue(noOfTables);
    	int noOfPerson = 0;
    	System.out.print("\nCustomer name :");
    	String name = myscanner.next();
        while(intialstate != 0) {
	        try {
	        	System.out.print("\nEnter number of persons :");
	        	noOfPerson = myscanner.nextInt(); 
		        System.out.println("-----------------------------------");      	
	        }catch(InputMismatchException  e ) {
	        	e.printStackTrace();
	        }
	        
	        //The restaurant having tables with maximum of 5 person(5 chairs per table)
	        boolean allowAllocation = RestaurantUtils.allocation(noOfPerson);
	        if(allowAllocation == true) {
	        	
	        	//passing the values to the queue and check whether there is available spaces
	        	if(table.isFull() == false) {
		        	System.out.println("You are welcome for the Olive Garden Restaurant !");
		        	System.out.print("Do you want to exit or allocate another table(Press 0 to exit, press 1 to continue) :");
		        	intialstate = myscanner.nextInt();
		        	table.allocateTable(noOfPerson);
		        	
		        	if(intialstate == 0) {
		    	        System.out.println("==========Thank you for allocating  table!!=============");
		    	        System.out.println("=========================================================");
		    	        
		        	}
	        	}
	        	else {
	        		System.out.println("Sorry, All the tables are allocated in this time");
		        	System.out.print("Do you want to continue(Enter 1 to proceed, enter 0 to exit) :");
		        	int proceedToNext = myscanner.nextInt();
	        	}
	        }
	        else {
	        	System.out.println("Sorry, We do have tables containing maximum 10 seats !");
	        	System.out.print("Do you want to exit(Press 0 to exit, press 1 to continue) :");
	        	intialstate = myscanner.nextInt();

	        }      
        } 
        System.out.println("===== Menu Item List ======");
    	RestaurantService rest = new RestaurantServiceImpl();
    	rest.displayFoodItems();
		
	
	
	}

	@Override
	public void calculatingprice() {
		// TODO Auto-generated method stub
		Scanner myscanner = new Scanner(System.in);
		double totalPrice =0;
		System.out.print("\n\nEnter the food item number you want(Enter 0 to exit) :");
		int foodItemNo = myscanner.nextInt();
		int quantity =0;
		if(foodItemNo !=0) {
			System.out.print("Quantity :");
			quantity = myscanner.nextInt();				
		}
    	RestaurantService rest = new RestaurantServiceImpl();	
		while(foodItemNo != 0) {

			   totalPrice = rest.calculateFoodPrice(foodItemNo,quantity);
			   System.out.print("\nEnter the food item number you want(Enter 0 to exit) :");
			   foodItemNo = myscanner.nextInt();
			   if(foodItemNo != 0) {
				   System.out.print("Quantity :");
				   quantity = myscanner.nextInt();
			   }
		}
		if(foodItemNo == 0) {	
			rest.orderedList();
			System.out.println("======= Total Price "+ totalPrice+" =========");
			
		}else {
			
			System.out.println("Thank you. Come Again");
		}
		
		
		
		
		
	}
	
	@Override
	public void printBill() {
		// TODO Auto-generated method stub
		
		PrintWriter writer;
		try {
			writer = new PrintWriter("RestaurantBill.txt", "UTF-8");
			writer.println("The first line");
			writer.println("The second line");
			writer.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		
	}


	
	
	
	
	
	

}
