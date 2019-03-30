package com.mtit.osgi.restaturantservicerestaurant.Impl;




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import com.dsa.osgi.restaurantserviceresturant.*;

public class RestaurantServiceImpl implements RestaurantService {
	

	@Override
	public void DisplayMenuList() {
		// TODO Auto-generated method stub	
		System.out.println("\n\n===== Meal Time =====");
		
	}

	@Override
	public void displaycalculatingDetails() {
		// TODO Auto-generated method stub
		
		int i =1;
		double stringHopperPrice =15.0;
		double riceAndCurryPrice = 200.0;
		double breadprice = 150.0;
		double rotiprice = 100.0;
		Scanner myscanner = new Scanner(System.in);
		while(i != 0) {
			
			System.out.println("Enter the meal you want :");	
			int mealCategory = myscanner.nextInt();
			System.out.println("Enter the quantity you want :");
			int quantity = myscanner.nextInt();
			
			double totalPrice =0;
			if(mealCategory == 1) {
				
				totalPrice = totalPrice+quantity*stringHopperPrice;
			}
			
		}
			
		
	}
	
	
	static String arrayItems[] = new String[5];
	static double arrayItemsPrice[] = new double[5];
	static String orderedList[] = new String[20];
	static double quantityList[] = new double[20];
	static double priceList[] = new double[30];
	static int i =0,passingValues =0;
	@Override
	public void getFoodItems(String foodsName,double price) {
		// TODO Auto-generated method stub

			arrayItems[i] = foodsName;
			arrayItemsPrice[i] = price;
			i++;
	}
	@Override
	public void displayFoodItems() {
		// TODO Auto-generated method stub
		System.out.println("= Number ===    Item Name==              ====Price====   ");
		int j =0; 
		 while(j< 5) {
			 
			 if(arrayItems[j] == null) {
				 
				 System.out.println("  "+(j+1)+".          "+"Not Available"+"                 "+ arrayItemsPrice[j]+"   ");	
			 }
			 else {
				 
				 System.out.println("  "+(j+1)+".           "+arrayItems[j]+"                   "+ arrayItemsPrice[j]+"   "); 
			 }
			 
			 j++;
		 }	
	}

	static double totalPrice =0.0;
	static int orderfood =0;
	@Override
	public double calculateFoodPrice(int foodNo,int quantity) {
		// TODO Auto-generated method stub
		

		if(foodNo >5 && foodNo < 0) {
			
			System.out.println("Error!, Item range in between 1 to 5");
		}
		else if(quantity <0 ){
			
			System.out.println("Error!, Quantity must be greater than 0");
			
		}
		else if(quantity >10) {
			
			System.out.println("Can only provide maximum 10 items");
		}
		else {
			int actualFoodNo = foodNo -1;
			String foodName = arrayItems[actualFoodNo];
			double price = arrayItemsPrice[actualFoodNo];
			orderedList[orderfood] = foodName;
			quantityList[orderfood] = quantity;
			double quantityPrice = price*quantity;
			priceList[orderfood] = quantityPrice;
			totalPrice = totalPrice+quantityPrice;
			passingValues++;
			orderfood++;
			
//			System.out.println(foodName+"   ===============     " +quantityPrice);
			
		}
		return totalPrice;

	}

	@Override
	public void orderedList() {
		// TODO Auto-generated method stub
		System.out.println("Item Name    " + "        Quantity   "+"    Price    ");
		i=0;
		while(i < passingValues) {
					
			System.out.println(orderedList[i]+"              "+ quantityList[i]+ "              "+priceList[i]);
			i++;
		}
		
		
	}
	
	static String name = null;
	@Override
	public void receiveCustomerName(String Name) {
		// TODO Auto-generated method stub
		
		this.name = Name;
	}

	
	//In here, this is the code for printing the bill, that customer want
	@Override
	public void printBill() {
		// TODO Auto-generated method stub
		
		
        try {
            //In here there will be generate a bill including all the details client has added.
//            File statText = new File("E:/ajax_tutorial/RestaurantBill.txt");
            File statText = new File("E:/RestaurantBill.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            w.write("\t\t\t  ~OLIVE GARDEN RESTAURANT ~\t\t\t");
            String newLine = System.getProperty("line.separator");
            w.write(newLine);
            w.write("\t\tBill Number : "+i+1);
            w.write("\t\t  Customer Name:"+ name);
            w.write(newLine);
            w.write(newLine);
            w.write("\t  Name        ========          Quantity        ========    Price");
            w.write(newLine);
            i=0;
            while(i < passingValues) {
            	w.write("\t  "+orderedList[i]+" \t                    "+ quantityList[i]+ " \t                  "+priceList[i]+"   ");
                w.write(newLine);
            	i++;
            	
            	
            }
            w.write(newLine);
            w.write(newLine);
            w.write("\t=================================================================");
            w.write(newLine);
            w.write("\tTotal Price : "+totalPrice);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            w.write("\t\tDate and Time:"+dtf.format(now));
            w.write(newLine);
            w.write("\t=================================================================");
            w.write(newLine);
            w.write("\t=================================================================");
            w.close(); 
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }

		
	}



	

	
}
