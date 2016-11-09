package com.bayviewglen.dayfive;

import java.util.Scanner; 


public class HomeworkThree {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("please enter a six digit number:");
		
		int num = keyboard.nextInt();
		
		int digit2 = (num/10000) % 10;
		int digit4 = (num/100) % 10;
		
		
		int finalNum = digit2 * digit4;
		System.out.println("The product of the 2nd and 4th numbers are :  " + finalNum);
	
		
	}

}
