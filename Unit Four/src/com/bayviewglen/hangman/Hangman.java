package com.bayviewglen.hangman;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		final String ALPHANUMERALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
		final String ALPHANUMERALS_NO_SPACES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String possibleGuesses = "";
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Player One, Please enter your first name: ");
		String p1Name = keyboard.nextLine();

		System.out.print("Player Two, Please enter your first name: ");
		String p2Name = keyboard.nextLine();

		String message = "";
		String guess = "";
		String currentPlayer = null;
		String opposingPlayer = null;
		String coded = "";
		int p1Points = 0;
		int p2Points = 0;
		final int MAX_POINTS = 8;
		final int MAX_GUESSES = 7;
		int guesses;
		int rounds = 0;
		boolean gameOver = false;
		while (!gameOver) {
			possibleGuesses = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			guesses = 0;
			if (rounds % 2 == 0) {
				currentPlayer = p1Name;
				opposingPlayer = p2Name;
			} else if (rounds % 2 == 1) {
				currentPlayer = p2Name;
				opposingPlayer = p1Name;
			}

			System.out.print(opposingPlayer + ", please enter an alphanumeric message to be guessed: ");
			message = keyboard.nextLine().toUpperCase();
			System.out.println(message);
			boolean notChecked = true;
			while (notChecked) {
				notChecked = false;
				for (int i = 0; i < message.length(); i++) {
					if (ALPHANUMERALS.indexOf(message.charAt(i)) == -1) {
						System.out.print("ERROR --> " + opposingPlayer
								+ ", please enter an ALPHANUMERIC message to be guessed: ");
						message = keyboard.nextLine().toUpperCase();
						notChecked = true;
					}
				}
			}
			for (int i = 0; i < message.length(); i++) {
				if (message.charAt(i) == ' ')
					coded += "/ ";
				else
					coded += "_ ";
			}

			System.out.println(coded);
			boolean roundOn = true;
			while (guesses < MAX_GUESSES && roundOn) {
				System.out.print(opposingPlayer + ", you have used " + guesses
						+ " guesses, would you like to (1) solve or (2) guess a character: ");
				String inputChoice = keyboard.nextLine();
				while (!(inputChoice.equals("1") || inputChoice.equals("2"))) {
					System.out.print(opposingPlayer + ", you must enter (1) solve or (2) guess a character: ");
					inputChoice = keyboard.nextLine();
				}
				if (inputChoice.equals("1")) {
					System.out.print(opposingPlayer + ", please enter your solution: ");
					guess = keyboard.nextLine().toUpperCase();
					notChecked = true;
					while (notChecked) {
						notChecked = false;
						for (int i = 0; i < guess.length(); i++) {
							if (ALPHANUMERALS.indexOf(guess.charAt(i)) == -1) {
								System.out.print(
										"ERROR --> " + currentPlayer + ", please enter an ALPHANUMERIC solution: ");
								guess = keyboard.nextLine().toUpperCase();
								notChecked = true;
							}
						}
					}
					if (guess.equals(message)) {
						System.out.println(currentPlayer + ", you are correct!");
						roundOn = false;
					} else {
						System.out.println(currentPlayer + ", you are unfortunately incorrect!");
						guesses++;
					}

				} else if (inputChoice.equals("2")) {
					for (int i = 0; i < possibleGuesses.length(); i++) {
						System.out.print(possibleGuesses.charAt(i) + " ");

					}
					System.out.print("\n" + currentPlayer + ", please guess a single character: ");
					guess = keyboard.nextLine().toUpperCase();
					notChecked = true;
					while (notChecked) {
						/*
						 * if (ALPHANUMERALS_NO_SPACES.indexOf(guess) == -1) {
						 * System.out.print("ERROR --> " + currentPlayer +
						 * ", please either guess a letter or the message(using  ALPHANUMERIC charcters): "
						 * ); guess = keyboard.nextLine().toUpperCase(); } else
						 * if (possibleGuesses.indexOf(guess) == -1) {
						 * System.out.print("ERROR --> " + currentPlayer +
						 * ", please either guess a letter or the message(THAT YOU HAVEN'T BEFORE): "
						 * ); guess = keyboard.nextLine().toUpperCase(); } else
						 * { notChecked = false; possibleGuesses =
						 * possibleGuesses.substring(0,
						 * possibleGuesses.indexOf(guess)) + " " +
						 * possibleGuesses.substring(possibleGuesses.indexOf(
						 * guess) + 1); }
						 */

						if (ALPHANUMERALS_NO_SPACES.indexOf(guess) > -1) {
							notChecked = false;
							possibleGuesses = possibleGuesses.substring(0, possibleGuesses.indexOf(guess)) + " "
									+ possibleGuesses.substring(possibleGuesses.indexOf(guess) + 1);
						} else {
							if (guess.length() > 1)
								System.out.print("ERROR --> " + currentPlayer + ", please guess A letter: ");
							else if (ALPHANUMERALS_NO_SPACES.indexOf(guess) == -1) {
								System.out.print("ERROR --> " + currentPlayer
										+ ", please either guess a letter or the message(using  ALPHANUMERIC charcters): ");
								guess = keyboard.nextLine().toUpperCase();
							} else if (possibleGuesses.indexOf(guess) == -1) {
								System.out.print("ERROR --> " + currentPlayer
										+ ", please either guess a letter or the message(THAT YOU HAVEN'T BEFORE): ");
							}
							guess = keyboard.nextLine().toUpperCase();

						}

					}
					if (coded.indexOf(guess) != -1) {
						coded = coded.substring(0, 2 * coded.indexOf(guess)) + guess
								+ coded.substring(2 * coded.indexOf(guess) + 1);
						System.out.println(currentPlayer + ", the character '" + guess + "' is in the string!");
					} else {
						System.out.println(currentPlayer + ", the character '" + guess + "' is not in the string.");
					}
					System.out.println(coded);
					guesses++;
				}
			}

			if (guesses == MAX_GUESSES) {
				notChecked = true;
				System.out.print(
						currentPlayer + ", you have used up your guesses. Please enter your solution: ");
				guess = keyboard.nextLine().toUpperCase();
				while (notChecked) {
					notChecked = false;
					for (int i = 0; i < guess.length(); i++) {
						if (ALPHANUMERALS.indexOf(message.charAt(i)) == -1) {
							System.out.print(
									currentPlayer + ", please enter your solution using ALPHANUMERIC CHARACTERS: ");
							guess = keyboard.nextLine().toUpperCase();
							notChecked = true;
						}
					}
				}
				if (guess.equals(message)) {
					System.out.println("Correct");
				} else {
					System.out.println("Wrong");
					guesses ++;
				}
			}

			if (rounds % 2 == 0)
				p1Points += MAX_POINTS - guesses;	
			else if (rounds % 2 == 1)
				p2Points += MAX_POINTS - guesses;

			System.out.println("Total player points");
			System.out.println(p1Name + ": \t" + p1Points);
			System.out.println(p2Name + ": \t" + p2Points);

			if (rounds >= 10) {
				if (p1Points > p2Points) {
					System.out.println("Congratulations " + p1Name + ", you won!!");
					gameOver = true;
				} else if (p1Points < p2Points) {
					System.out.println("Congratulations " + p2Name + ", you won!!");
					gameOver = true;
				} else {
					System.out.println("You have tied. The next round will be the tie breaker");
				}
			}
			rounds++;

		}
		keyboard.close();

	}
}
