package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkFour {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the time?");
		int time = keyboard.nextInt();
		System.out.println("What is the innitial velocity?");
		int initialVelocity = keyboard.nextInt();
		System.out.println("What is the accelaration?");
		int accelaration = keyboard.nextInt();
	
		int finalVelocity = initialVelocity + accelaration * time;
		
		System.out.println("The final velocity is " + finalVelocity + " m/s.");
	}

}
