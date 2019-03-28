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

        
	}
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
