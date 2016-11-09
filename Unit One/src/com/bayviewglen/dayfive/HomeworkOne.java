
package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkOne {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter an integer: ");
		int num = keyboard.nextInt();
		int square = (int)(Math.pow(num, 2));
		System.out.println("The number is : " + num + " and the square is: " + square);
		
	}

}