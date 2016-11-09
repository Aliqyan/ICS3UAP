package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkTen {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many items did you sell");
		int items = keyboard.nextInt();
		double commission = items * 0.27;
		System.out.println("Your comission is : $" + commission);
	}

}
