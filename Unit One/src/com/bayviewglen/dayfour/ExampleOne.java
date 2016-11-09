package com.bayviewglen.dayfour;

public class ExampleOne {

	public static void main(String[] args) {
		System.out.println(3*6); 
		System.out.println(3+6);
		System.out.println(3/6);	// 0 - both are integers
		
		System.out.println(3.0/6);	// 18.0
		System.out.println(3+6.0);	// 9.0
		System.out.println(3.0/6); 	// 0.5 - one operand is a double so i get double division
		
		System.out.println(3%6);	// 3
		System.out.println(23%2); 	//1 this tells us that it is odd
		System.out.println(458548%10); 	//8 mod it 10 to get the last digit
	}

}
