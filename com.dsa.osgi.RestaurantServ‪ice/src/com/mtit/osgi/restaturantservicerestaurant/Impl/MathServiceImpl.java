package com.mtit.osgi.restaturantservicerestaurant.Impl;
import com.dsa.osgi.restaurantserviceresturant.*;

public class MathServiceImpl implements MathService {
	
	@Override
	public int sum(int a, int b) {
	       return a+ b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int division(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	 
}
