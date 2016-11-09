package com.bayviewglen.dayone;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {

		final int ONE = 1;
		Scanner keyboard= new Scanner (System.in);
		// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		final int CONSTANT_A = 100;
		int answerA = (int)(Math.random()* CONSTANT_A) + ONE;
		System.out.println("A number between 1 and 100: " + answerA);
		
		//bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
		final int CONSTANT_B = 50;
		int answerB = (int)(Math.random()* CONSTANT_A) - CONSTANT_B;
		System.out.println("A number between -50 and 50: " + answerB);
		
		//cccccccccccccccccccccccccccccccccccccccccccccccccccccc
		System.out.print("Please input two numbers:");
		int num1 = keyboard.nextInt();
		int num2 = keyboard.nextInt();
		int num3 = Math.max(num1, num2);
		int num4 = Math.min(num1, num2);
		int answerC = (int)(Math.random() * (num3-num4 + ONE) + num4);
		System.out.println("Here is your random number: " + answerC);
		
		//dddddddddddddddddddddddddddddddddddddddddddddddddddddd
		final int DICE_SIDES = 6;
		int diceValue = (int)(Math.random() * DICE_SIDES + ONE);
		System.out.println("The dice has rolled: " + diceValue);
		
		//eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
		System.out.print("Please input a scentence: ");
		String sentence = keyboard.nextLine();
		char randomLetter = sentence.charAt((int)(Math.random() * (sentence.length())));
		System.out.println("A random letter from the scentence is: " + randomLetter);
		
		//ffffffffffffffffffffffffffffffffffffffffffffffffffffff
		char randomUpperCase = (char)(Math.random() * 26 + 65);
		System.out.println("A random Capital letter is: " + randomUpperCase);

		//eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
		char randomLowerCase = (char)(Math.random() * 26 + 97);
		System.out.println("A random Capital letter is: " + randomLowerCase);
		keyboard.close();

	}

}
