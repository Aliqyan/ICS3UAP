package com.bayviewglen.ciphers;

import java.util.Scanner;

public class CeasarCipher {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("please enter a scentence to be decripted");
		String line = keyboard.nextLine();
		System.out.print("Please enter an INTEGR KEY:");
		int key = keyboard.nextInt();
		System.out.println("Please enter a key to encrypt the line: ");
		key %= 26;
		String encrypted = "";
		for (int x = 0; x < line.length(); x++) {
			int letter = (int) (line.charAt(x));
			if (letter > 122 - key) {
				letter = 97 + (letter + key - 123);
			} else {
				letter += key;
			}
			encrypted += (char) letter;
		}
		System.out.println(encrypted);

		keyboard.close();

	}

}