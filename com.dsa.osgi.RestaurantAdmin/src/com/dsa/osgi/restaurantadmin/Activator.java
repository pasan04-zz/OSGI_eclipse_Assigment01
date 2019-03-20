package com.dsa.osgi.restaurantadmin;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

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
        
      System.out.println("5+3 = " + service.sum(4, 3));

      System.out.println("MathConsumer Started");
     
      System.out.println("5 * 6 = " + service.multiplication(5, 6));
      
      System.out.println("100/10 = " + service.division(100, 10));
		
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
