package com.dsa.osgi.restaurantservice.utils;

import java.util.Scanner;

public class RestaurantUtils {
	 
	   int maxForTable = 5;
	   public static boolean allocation(int a)  {   
		   if(a >0 && a<= 10) {
			   return true;
		   }
		   else {
			   return false;
		   }
	   }
	   public static void calculatePrice(int type,int quantity,int price) {
	   }
	   
}
