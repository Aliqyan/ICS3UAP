package com.bayviewglen.dayseven;

import java.util.Scanner;

public class BayviewglenPool {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please input the length: ");
		double length = keyboard.nextDouble();
		System.out.print("Please input the width: ");
		double width = keyboard.nextDouble();

		System.out.print("Please input the height of the shallow end: ");
		double heightShallow = keyboard.nextDouble();
		System.out.print("Please input the height of the deep end: ");
		double heightDeep = keyboard.nextDouble();

		System.out.print("Please input the length between the shallow end and the deep end: ");
		double lengthInBetween = keyboard.nextDouble();

		System.out.print("Please input the length of the shallow end: ");
		double lengthShallow = keyboard.nextDouble();

		double liner1 = 2.72;
		double liner2 = 3.84;
		double liner3 = 4.83;

		double heightDiff = heightDeep - heightShallow;
		final double PERCENT_FULL = 0.9;
		final double CONVERT_TO_LITRES = 1000;
		double baseInBetween = Math.sqrt(Math.pow(lengthInBetween, 2) - Math.pow(heightDiff, 2));
		System.out.println(baseInBetween);
		double volume = CONVERT_TO_LITRES * PERCENT_FULL * ((length * heightDeep * width)
				- ((lengthShallow * heightDiff * width) + ((baseInBetween * heightDiff * width) / 2)));

		System.out.println("The volume is: " + volume + " litres");

		/////////// Surface Area////////////////
		double lengthDeep = length - (baseInBetween + lengthShallow);

		double areaBottom = (lengthShallow + lengthDeep + lengthInBetween) * width;
		double areaSideDeep = width * heightDeep;
		double areaSideShallow = width * heightShallow;
		double areaSide = (length * heightDeep) - (heightDiff * lengthShallow + (heightDiff * baseInBetween) / 2);
		double surfaceAreaTotal = areaBottom + areaSideDeep + areaSideShallow + 2 * areaSide;
		System.out.println("The total Surface Area is: " + surfaceAreaTotal + "m^2");

		double liner1Price = (int) (surfaceAreaTotal * liner1 * 100) / 100.0;
		double liner2Price = (int) (surfaceAreaTotal * liner2 * 100) / 100.0;
		double liner3Price = (int) (surfaceAreaTotal * liner3 * 100) / 100.0;

		System.out.println("The price of liner 1 is: $" + liner1Price);
		System.out.println("The price of liner 2 is: $" + liner2Price);
		System.out.println("The price of liner 3 is: $" + liner3Price);

	}

}
