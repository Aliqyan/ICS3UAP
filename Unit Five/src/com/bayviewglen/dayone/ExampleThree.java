package com.bayviewglen.dayone;

import java.util.Scanner;

public class ExampleThree {

	public static void main(String[] args) {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Please chose a number limit: ");
			boolean checked = false;
			int choice = 0;
			while (!checked){
				checked = true;
				choice = keyboard.nextInt();
				if(choice > 17){
					System.out.print("Please chose a number limit, UNDER 17: ");
					checked = false;					
				}
			}
			findFactorial(choice);
		}
		public static void findFactorial(int n){
			int product = 1;
			for(int i = 1; i < n; i++){
				product *= i;
			}
			System.out.println("The factorial is: " + product);
		}
	}


