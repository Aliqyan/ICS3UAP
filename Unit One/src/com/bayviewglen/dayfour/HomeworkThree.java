package com.bayviewglen.dayfour;
import java.util.Scanner; 


public class HomeworkThree {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("please enter a six digit number:");
		
		int num = scan.nextInt();
		
		int digit2 = (num/10000) % 10;
		int digit5 = (num/10) % 10;
		
		
		int finalNum = digit2 * digit5;
		System.out.println("The product of the 2nd and 5th numbers are :  " + finalNum);
	
		
	}

}
