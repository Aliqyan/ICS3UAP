package com.bayviewglen.dayfour;

import java.util.ArrayList;

public class ExampleOne {

	public static void main(String[] args) {
		ArrayList<Integer> marks  = new ArrayList<Integer>();
		marks.add(new Integer(7));
		marks.add(29); // autoboxing 
		int x = 3 + new Integer(9); // auto unboxing
		marks.add(0, 100);

		System.out.println(marks);
		
		int y = marks.set(1, 200);
		System.out.println(marks);
		System.out.println(y);
		
		int z = marks.remove(1);
		marks.add(29);
		System.out.println(marks);
		System.out.println(z);
		
		marks.remove(new Integer(29));
		System.out.println(marks);
	}

}
