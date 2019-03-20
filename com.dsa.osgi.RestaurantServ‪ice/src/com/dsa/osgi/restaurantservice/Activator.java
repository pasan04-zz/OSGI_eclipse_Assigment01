package com.dsa.osgi.restaurantservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.dsa.osgi.restaurantserviceresturant.MathService;
import com.mtit.osgi.restaturantservicerestaurant.Impl.MathServiceImpl;

public class Activator implements BundleActivator {
 
   private static BundleContext context;
 
   static BundleContext getContext() {
       return context;
   }
 
   public void start(BundleContext bundleContext) throws Exception {
       Activator.context = bundleContext;
        
       System.out.println("Registry Service MathService...");
        
       this.registryMathService();
        
       System.out.println("OSGi MathService Started");
   }
 
   private void registryMathService() {
       MathService service = new MathServiceImpl();
       context.registerService(MathService.class, service, null);
   }
 
   public void stop(BundleContext bundleContext) throws Exception {
       Activator.context = null;
       System.out.println("OSGi MathService Stopped!");
   }
 
}