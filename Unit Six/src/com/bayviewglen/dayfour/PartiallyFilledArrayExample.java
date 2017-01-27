package com.bayviewglen.dayfour;

public class PartiallyFilledArrayExample {
	static int[] data = new int[10];
	static int howMany = 0;
	
	public static void main(String[] args) {
		display(); 
		add(6);
		add(16);
		add(63);
		add(-61);
		display(); 
		
		deleteAtIndex(2);
		display(); 

		deleteAtIndex(2);
		display(); 
		
		insert(76, 3);
		display(); 

		insert(-76, 1);
		display(); 
		
		deleteAtIndexOrdered(2);
		display(); 
		
		deleteAtIndexOrdered(0);
		display(); 
		


	}

	private static void deleteAtIndexOrdered(int pos) {
		for(int i = pos; i < howMany; i++){
			data[i] = data[i+1];
		}
		howMany--;
		
	}

	private static void insert(int value, int pos) {
		for(int i = howMany; i > pos; i--){
			data[i] = data[i-1];
		}
		data[pos] = value;
		howMany++;
	}

	private static void deleteAtIndex(int value) {
		data[value] = data[--howMany];
	}

	private static void add(int value) {
		data[howMany++] = value;
	}

	private static void display() {
		System.out.println("The partially filled array with " + howMany + " elements: ");
		for(int i = 0; i < howMany; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
	}
	
	
}
