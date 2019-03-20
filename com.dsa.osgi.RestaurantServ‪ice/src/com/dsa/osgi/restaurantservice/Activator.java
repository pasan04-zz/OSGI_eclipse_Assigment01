package com.dsa.osgi.restaurantservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.dsa.osgi.restaurantserviceresturant.RestaurantService;
import com.mtit.osgi.restaturantservicerestaurant.Impl.MathServiceImpl;

public class Activator implements BundleActivator {
 
   private static BundleContext context;
 
   static BundleContext getContext() {
       return context;
   }
 
   public void start(BundleContext bundleContext) throws Exception {
       Activator.context = bundleContext;
        
       System.out.println("Registry Service Restaurant ...");
        
       this.registryMathService();
        
       System.out.println("OSGi Restaurant service Started");
   }
 
   private void registryMathService() {
       RestaurantService service = new MathServiceImpl();
       context.registerService(RestaurantService.class, service, null);
   }
   public void stop(BundleContext bundleContext) throws Exception {
       Activator.context = null;
       System.out.println("OSGi Restaurant Service Stopped!");
   }
 
}