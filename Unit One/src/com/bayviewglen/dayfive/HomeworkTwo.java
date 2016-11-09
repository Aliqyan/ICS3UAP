package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkTwo {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter your score ant then the total amount of points on the test: ");
		int score = keyboard.nextInt();
		int amount = keyboard.nextInt();
		int percentage = (int)(score/(double)amount * 100);
		System.out.println("The test percentage is " + percentage + "%.");
	}

}
