package com.dsa.osgi.restaurantconsumer;

import com.dsa.osgi.restaurantservice.utils.RestaurantUtils;

import com.dsa.osgi.restaurantservice.utils.TableQueue;
import com.dsa.osgi.restaurantserviceresturant.RestaurantService;
import com.mtit.osgi.restaturantservicerestaurant.Impl.RestaurantServiceImpl;
import com.sa.osgi.restaurantconsumer.Impl.RestaurantConsumerServices;
import com.sa.osgi.restaurantconsumer.consumer.RestaurantConsumer;

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
        ServiceReference<RestaurantService> serviceReference = context.getServiceReference(RestaurantService.class);
        RestaurantService service = (RestaurantService) context.getService(serviceReference);
        
        System.out.println("\n\n~WELCOME TO OLIVE GARDEN RESTAURANT RESERVATION~");
        System.out.println("================================================");
        
        RestaurantConsumer restConsumer = new RestaurantConsumerServices();
        RestaurantService restService = new RestaurantServiceImpl();
        restConsumer.allocatingTable();
        restConsumer.calculatingprice();
        Scanner myscanner = new Scanner(System.in);
        System.out.print("Do you want a bill(Enter 1 to get the bill, if not enter 0) :");
        int printBill = myscanner.nextInt();
        if(printBill == 1) {
        	restService.printBill();
        	System.out.println("Your bill is printed !");
        	System.out.println("\nThank you. See you again ........");
        }
        else {	
        	System.out.println("Thank you. See you again ........");
        }
 
    }
 
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
        System.out.println("Restaurant Client Stopped");
    }
 
}