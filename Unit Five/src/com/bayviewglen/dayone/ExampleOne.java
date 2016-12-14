package com.bayviewglen.dayone;

import java.util.Scanner;

public class ExampleOne {

	public static void main(String[] args) {
		/*
		int x = 25;
		int y = findSum(x);
		System.out.println(y);
		
		int z = 4;
		System.out.println(findCube(z));
		String goodString = getAlphaNumericString();
		System.out.println("The good string is: " + goodString);
		int n =10;
		*/
		int n = 10;
		System.out.println("Youy rolled a:" + roll(4));
	}

	public static int findSum(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += n;
		}
		return sum;

	}
	public static double findCube(double x){
		return x*x*x;
	}


	public static String getAlphaNumericString() {
		Scanner keyboard = new Scanner(System.in);
		String valid = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		System.out.print("Please enter a scentence: ");
		String scentence = "";
		boolean isValid = false;
		while (!isValid){
			isValid = true;
			scentence = keyboard.nextLine().toUpperCase();
			for(int i = 0; i < scentence.length(); i ++){
				if(valid.indexOf(scentence.charAt(i)) == -1){
					isValid = false;
				}
				if(!isValid){
					System.out.println("Bruh enter scentence: ");
				}
			}
		}
		return scentence;
	}
	
	public static int roll(int numSides){
		if (numSides<3)
			throw new IllegalArgumentException("num of sides must be over 3");
		return (int)(Math.random() * numSides + 1);
	}
}
