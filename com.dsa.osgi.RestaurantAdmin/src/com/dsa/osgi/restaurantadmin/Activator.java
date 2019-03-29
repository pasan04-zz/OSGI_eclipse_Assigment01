package com.dsa.osgi.restaurantadmin;

import java.util.Scanner;


import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.dsa.osgi.restaurantservice.utils.TableQueue;
import com.dsa.osgi.restaurantserviceresturant.RestaurantService;
import com.mtit.osgi.restaturantservicerestaurant.Impl.RestaurantServiceImpl;
import com.sa.osgi.restaurantadmin.Impl.RestaurantAdminServices;
import com.sa.restaurantadmin.admin.RestaurnatAdmin;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
        ServiceReference<RestaurantService> serviceReference = context.getServiceReference(RestaurantService.class);
        RestaurantService service = (RestaurantService) context.getService(serviceReference);
        
        TableQueue tablequeue = new TableQueue(2);
        Scanner myscanner = new Scanner(System.in);
        System.out.println("======= Welcome to OLIVE GARDEN restaurant Administrator! ===============");
        
        System.out.println("====== Select option ======");
        
        System.out.println("   1. Deallocate a table ");       
        System.out.println("   2. Add Foods to the menu");
        System.out.print("Enter the option you want to change(press 0 to exit) :");
        int option = myscanner.nextInt();
        
        while(option != 0) {
	        switch(option) {
	        	case 1 :{
	                System.out.print("How many tables do you want to deallocate :"); 
	                int noOfTables = myscanner.nextInt();
	                for(int i=1;i<=noOfTables;i++) {
	                    tablequeue.deallocateTable();
	                }
	                System.out.println("Succesfully deallocated "+ noOfTables+" tables");  
	                System.out.println(" ");
	                break;
	        	}
	        	case 2:{
	                System.out.println("==============================================");
	                System.out.print("Select a number to continue(Press 1 to food enter, press 2 to price changing) :");
	                int number = myscanner.nextInt();
	                System.out.println("==========================================================================");
                	RestaurnatAdmin restAdmin = new RestaurantAdminServices();
	                if (number == 1) {
	                	System.out.println("------------  Add Food Item interface --------------------------------");

	                	restAdmin.addFoodItems();
	                }
	                else {
	                	System.out.println("-------------- Price changing interface ---------");
	                	restAdmin.priceChanging();
	                break;
	        	} 

	        }
	        System.out.println("====== Select option ======");
	        System.out.println("   1. Deallocate a table(Enter 1) ");       
	        System.out.println("   2. Add Foods to the menu(Enter 2)");
	        System.out.print("Enter the option you want to change(press 0 to exit) :");
	        option = myscanner.nextInt();
	        }
        }

      
	}
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Restaurant administrator has stopped");
	}
	

}
