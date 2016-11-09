/*
 * Example: While Loop without an if statement.
 * 
 * Write a program that will sum all of numbers between two numbers that the user enters.
 * 
 */
package com.bayviewglen.dayone;

import java.util.Scanner;

public class ExampleOne {

	public static void main(String[] args) {
	int sum = 0;
	int current = 1;
	while (current < 1001){
		sum += current;
		current ++;
	}
	System.out.println("The sum of sthe numbers from 1 to 1000 id: " + sum);
	}
}