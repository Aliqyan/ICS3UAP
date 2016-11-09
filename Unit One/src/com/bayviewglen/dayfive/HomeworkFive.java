package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkFive {

	public static void main(String[] args) {
		Scanner keyboardDouble = new Scanner (System.in);
		Scanner keyboardInt = new Scanner (System.in);
		System.out.print("The value for x is: ");
		double x = keyboardDouble.nextDouble();
		System.out.print("The value for y is: ");
		double y = keyboardDouble.nextDouble();
		System.out.print("The value for y is: ");
		double z = keyboardDouble.nextDouble();
		
		System.out.print("The integer value for i is: ");
		int i = keyboardInt.nextInt();
		System.out.print("The integer value for j is: ");
		int j = keyboardInt.nextInt(); 
		System.out.print("The integer value for k is: ");
		int k = keyboardInt.nextInt();
		
		//a
		
		System.out.println(i-(i-(i-(i-j))));
		
		int aBracketFour = i - j;
		int aBracketThree = i -aBracketFour;
		int aBracketTwo = i - aBracketThree;
		int aBracketOne = i - aBracketTwo;
		
		System.out.println(aBracketOne);
		System.out.println("");
		
		//b
			
		System.out.println((x-y) * (x+(i-j)));
		double bBracketOne = x-y;
		int bBracketTwo = i-j;
		double bBracketThree = x + bBracketTwo;
		double bAnswer = bBracketOne * bBracketThree;
		System.out.println(bAnswer);
		System.out.println("");
		
		//c
		
		System.out.println((x-y)-(y-x)-(x-y)-(y-x));	
		double cBracketOne = x-y;
		double cBracketTwo = y-x;
		
		double cAnswer = cBracketOne - cBracketTwo - cBracketOne - cBracketTwo;
		System.out.println(cAnswer);
		System.out.println("");
		
		//h
		
		System.out.println((double)i-j/k);
		
		double hDivision = j/k;
		double hBracketOne = i - hDivision;
		double hAnswer = hBracketOne;
		System.out.println(hAnswer);
		System.out.println("");
		
		//i
		System.out.println((int)x/ k-x/k);
		double iDiv = x/k;
		double iAnswer = (int)iDiv -iDiv;
		System.out.println(iAnswer);
		System.out.println("");
		
		//j
		System.out.println((double) i/j - (double)(i/j));
		double jMaster1 = (double)i/j;
		double jMaster2 = i/j;
		double jAnswer = jMaster1 - jMaster2;
		System.out.println(jAnswer);

		
		
		
		
	}

}
