package com.dsa.osgi.restaurantadmin;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.dsa.osgi.restaurantservice.utils.TableQueue;
import com.dsa.osgi.restaurantserviceresturant.RestaurantService;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
        ServiceReference<RestaurantService> serviceReference = context
                .getServiceReference(RestaurantService.class);
        RestaurantService service = (RestaurantService) context
                .getService(serviceReference);
        
        TableQueue tablequeue = new TableQueue(2);
        Scanner myscanner = new Scanner(System.in);
        System.out.println("======= Welcome to OLIVE GARDEN restaurant Administrator! ===============");
        System.out.print("How many tables do you want to deallocate :");  
        int noOfTables = myscanner.nextInt();
        for(int i=1;i<=noOfTables;i++) {
            tablequeue.deallocateTable();
        }
        System.out.println("Succesfully deallocated the "+ noOfTables+"tables");
        
        
//      System.out.println("Enter a value :");
//      int a = myscanner.nextInt();
//      System.out.println("5+3 = " + service.sum(a, 3));
//
//      System.out.println("MathConsumer Started");
//     
//      System.out.println("5 * 6 = " + service.multiplication(5, 6));
//      
//      System.out.println("100/10 = " + service.division(100, 10));       

        
	}
	
	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
