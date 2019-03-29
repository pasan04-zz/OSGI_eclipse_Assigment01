package com.dsa.osgi.restaurantservice.utils;

public class TableQueue {
	
	private int maxNoOfTable;
	private static int rear;
	private static int front;
	private static int[] queArray;
	private static int nTable;
	
	
	//Table allocation is going in a queue structure
	//The restaurant having tables with the same no of chairs
	//The restaurant having 10 tables and each have 4 number of chairs
	public TableQueue(int maxSize) {

		this.maxNoOfTable = maxSize;
		queArray = new int[maxSize];
		nTable = 0;
		front =0;
		rear = -1;	
	}
	public void allocateTable(int j) {
		
		if(rear == maxNoOfTable) {
			
			System.out.println("All the tables are allocated. Sorry!");
		}
		else {
			if(rear == maxNoOfTable-1) {
				
				rear =-1;
			}
			rear++;
			queArray[rear] =j;
			nTable++;
		}
		
	}
	
	public int deallocateTable() {
		if(nTable ==0) {
			System.out.println("All the tables are not allocated !");
			return -99;
		}
		else {
			int temp = queArray[front];
			front++;
			if(front == maxNoOfTable) {
				front =0;
			}
			nTable --;
			return temp;		
		}	
	}
	
	public int peekFrontTable() {
		
		if(nTable == 0) {
			System.out.println("The restaurant is empty");
			return -99;
		}
		else {
			return queArray[front];
			
		}
	}
	
	public boolean isFull() {
		
		return rear==maxNoOfTable-1;
	}
	
	public boolean isEmpty() {
		
		return nTable==0;
	}
	
	

}
