package com.dsa.osgi.restaurantconsumer;

import com.dsa.osgi.restaurantservice.utils.RestaurantUtils;
import com.dsa.osgi.restaurantservice.utils.TableQueue;
import com.dsa.osgi.restaurantserviceresturant.RestaurantService;
import com.mtit.osgi.restaturantservicerestaurant.Impl.RestaurantServiceImpl;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
	 
    private static BundleContext context;
 
    static BundleContext getContext() {
        return context;
    }
 
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        System.out.println("Restaurant client is starting...");
 
        ServiceReference<RestaurantService> serviceReference = context
                .getServiceReference(RestaurantService.class);
        RestaurantService service = (RestaurantService) context
                .getService(serviceReference);
        Scanner myscanner = new Scanner(System.in);
        int intialstate = 1;
        int noOfTables = 2;
        
        //creating an object from Tablequeue inorder to check the availabity of the table in the restaurant
        TableQueue table = new TableQueue(noOfTables);
    	int noOfPerson = 0,bookingDate =0;
        while(intialstate != 0) {
        	
	        System.out.println("\n\n~WELCOME TO OLIVE GARDEN RESTAURANT RESERVATION~");
	        System.out.println("================================================");

	        try {
	        	System.out.print("Enter number of person :");
	        	noOfPerson = myscanner.nextInt(); 
		        System.out.println("-----------------------------------");
		        System.out.print("Enter Date :");
		        bookingDate = myscanner.nextInt();        	
	        }catch(InputMismatchException  e ) {
	        	e.printStackTrace();
	        }
	        System.out.println("-----------------------------------");
	        System.out.print("Enter the time :");
	        float bookingTime = myscanner.nextFloat();
	        System.out.println("-----------------------------------");
	        
	        //The restaurant having tables with maximum of 10 person(10 chairs)
	        boolean allowAllocation = RestaurantUtils.allocation(noOfPerson);

	        if(allowAllocation == true) {
	        	
	        	if(table.isFull() == false) {
		        	System.out.println("You can book the table !");
		        	System.out.print("Do you want to exit or allocate another table(Press 0 to exit, press 1 to continue :");
		        	intialstate = myscanner.nextInt();
		        	table.allocateTable(noOfPerson);
		        	
		        	if(intialstate == 0) {
		    	        RestaurantService restaurant = new RestaurantServiceImpl();
		    	        System.out.println("==========Thank you for allocating a table!!=============");
		    	        System.out.println("=========================================================");
		    	        restaurant.DisplayMenuList();
		    	        try {
			    	        System.out.print("Enter the meal time :");
			    	        int mealTime = myscanner.nextInt();
			    	        restaurant.selectMealType(mealTime);
		    	        }catch(InputMismatchException e) {
		    	        	e.printStackTrace();
		    	        }
		    	        	
		    	        
		        	}
	        	}
	        	else {
	        		System.out.println("Sorry, All the tables are allocated in this time");
		        	System.out.print("Do you want to exit or allocate another table(Press 0 to exit, press 1 to continue :");
		        	intialstate = myscanner.nextInt();
	        	}
	        }
	        else {
	        	System.out.println("Sorry, We do have tables containing maximum 10 seats !");
	        	System.out.print("Do you want to exit(Press 0 to exit, press 1 to continue :");
	        	intialstate = myscanner.nextInt();
	        }      
        }     
    }
 
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
        System.out.println("Restaurant Client Stopped");
    }
 
}