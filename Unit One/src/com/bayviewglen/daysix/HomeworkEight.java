package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkEight {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a positive number: ");
		int num = keyboard.nextInt();
		double sqrt = (int)(Math.sqrt(num)*100)/100.0;
		double square= Math.pow(num, 2);
		System.out.println("The square root is " + sqrt + " and the square is: " +  square);
		
	}

}
