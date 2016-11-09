package com.bayviewglen.dayfour;

public class HomeworkFive {

	public static void main(String[] args) {
		double x = 5.5, y = 3.0, z = -2.0;
		int i = 5, j = 4, k = 3;
		
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
