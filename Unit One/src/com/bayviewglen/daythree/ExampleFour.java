package com.bayviewglen.daythree;

public class ExampleFour {

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		double c = 2.0, d = 5.0;
		double e;
		int f;
		
		e = c * d;
		System.out.println(e);
		
		e = c / d;
		System.out.println(e);
		
		f = a * b;
		System.out.println(f);
		
		f = b / a;
		System.out.println(f);
		
		e = b / a;			//integer division always chops of the decimal
		System.out.println(e);
		
		f = b % a;			//mod gets the remainder
		System.out.println(f); 
	}

}
