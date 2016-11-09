package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkNine {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		System.out.print("The length is: ");
		int length = keyboard.nextInt();
		System.out.print("The width is: ");
		int width = keyboard.nextInt();
		int area = length * width;
		System.out.println("The area is: " + area + "cm^2");
	}

}
