package com.bayviewglen.dayseven;

public class ExampleOne {

	public static void main(String[] args) {
		int secondsPerMinute = 60;
		int minutesPerHour = 60;
		int hoursPerDeay = 24;
		int daysPerYear = 265;
		/////////////
		final int SECONDS_PER_MINUTE = 60; // makes it a constant, the upper case shows the case
		final int MINUTES_PER_HOUR = 60;
		final int HOURS_PER_DAY = 24;
		final int DAYS_PER_YEAR = 265; 
		
		final int SECONDS_PER_YEAR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR * HOURS_PER_DAY * DAYS_PER_YEAR;
		System.out.println(SECONDS_PER_YEAR);
		
		////////////////////
		
		double radius = 4.2;
		double area = Math.PI * Math.pow(radius, 2); // PI is a constant thats why capitalized
		
		////////////////////
		
		final int Num_Sides = 6;
		// random number from 1 -> 6
		int topOfDie = (int)(Math.random() * Num_Sides + 1); //Math is a class thats why first letter is capitalized
		// first use the Math class than * for the range, shift for range, and cast as int
		
		// [-10 ... 10]
		int range = (int)(21 * Math.random() - 10);
		
		
	}

}
