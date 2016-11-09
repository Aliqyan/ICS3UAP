package com.bayviewglen.daythree;

public class HomeworkSix {

	public static void main(String[] args) {
		double a, b, c;
		
		a = -3;
		b = 2;
		c = 4;		
		
		double discriminant = b*b - 4*a*c;
		double rootPositive = (-b + Math.sqrt(discriminant))/(2*a);
		double rootNegative = (-b - Math.sqrt(discriminant))/(2*a);
		
		System.out.println("The roots of this equation are " + rootPositive + ", and " + rootNegative + ".");
		
	}

}
