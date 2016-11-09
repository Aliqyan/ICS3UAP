package com.bayviewglen.daysix;

public class HomeworkFour {

	public static void main(String[] args) {
		int days = 365;
		int hours = 24;
		int min = 60;
		int sec = 60;
		sec *= days * hours * min;
		double distance = (double)sec * 3 * Math.pow(10, 8);
		System.out.println("The distance is: " + distance);
	}

}
