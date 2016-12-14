package com.bayviewglen.dayone;

import java.util.Scanner;

public class ExampleTwo {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please chose a number limit: ");
		int choice = keyboard.nextInt();
		sumSequence(choice);
	}
	public static void sumSequence(int n){
		int sum = 0;
		for(int i = 1; i < n; i++){
			sum += i;
		}
		System.out.println("The sum is: " + sum);
	}
}
