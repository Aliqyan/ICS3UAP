package com.bayviewglen.daythree;

public class HomeworkFive {

	public static void main(String[] args) {
		double pennies, nickels, dimes, quarters, loonies, toonies;
		
		pennies = 28;
		nickels = 84;
		dimes = 72;
		quarters = 19;
		loonies = 73;
		toonies = 83;
		
		double totalMoney = 0.01*pennies + 0.05*nickels + 0.1*dimes + 0.25*quarters + loonies + 2* toonies;
		System.out.println("The total money is $" + totalMoney + ".");
	}

}
