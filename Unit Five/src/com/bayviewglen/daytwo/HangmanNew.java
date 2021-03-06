package com.bayviewglen.daytwo;

import java.util.Scanner;

public class HangmanNew {
	
	final static String ALPHANUMERALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
	final static int MAX_POINTS = 8;
	final static int MAX_GUESSES = 7;
	final static int PLAYER_DECIDER = 2;
	final static int IS_PLAYER_1_TURN = 1;
	final static int IS_PLAYER_2_TURN = 0;
	final static int MISSING_INDEX = -1;
	final static int ONE_CHAR_OVER = 1;
	final static int NUM_SPACE_LINES = 48;
	final static int STARTING_CHAR = 0;
	final static int MAX_ROUNDS = 5;
	final static int TURNS_IN_ROUND = 2;
	final static int FINISHED_ROUNDS = 0;
	final static int LENGTH_ONE = 1;
	public static void main(String[] args) {
		// Declaring final variables
	
		String message = null;
		String guess = null;
		String currentPlayer = null;
		String opposingPlayer = null;
		int p1Points = 0;
		int p2Points = 0;
		int turns = 1;
		int rounds = 1;

		// prompt player for names
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Player One, Please enter your first name: ");
		String p1Name = keyboard.nextLine().trim();

		System.out.print("Player Two, Please enter your first name: ");
		String p2Name = keyboard.nextLine().trim();

		// run the loop ten times, if there is a tie, continue running the loop
		boolean gameOver = false;
		while (!gameOver) {

			// determine each players roles
			if (turns % PLAYER_DECIDER == IS_PLAYER_1_TURN) {
				currentPlayer = p1Name;
				opposingPlayer = p2Name;
			} else if (turns % PLAYER_DECIDER == IS_PLAYER_2_TURN) {
				currentPlayer = p2Name;
				opposingPlayer = p1Name;
			}
			System.out.println("------------------------- Round " + rounds + ": " + currentPlayer
					+ "'s turn ------------------------- ");
			String possibleGuesses = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			int guesses = 0;
			String coded = "";

			System.out.print(opposingPlayer + ", please enter an alphanumeric message to be guessed: ");
			// check if only alphanumeric characters are used
			message = checkIt(keyboard, opposingPlayer);

			// Space the code out
			for (int i = 0; i < NUM_SPACE_LINES; i++)
				System.out.println();

			// encode the message
			for (int i = 0; i < message.length(); i++) {
				if (message.charAt(i) == ' ')
					coded += "/";
				else
					coded += "_";
			}
			// print the coded message with spaces in between the coded
			// characters
			for (int i = 0; i < coded.length(); i++) {
				System.out.print(coded.charAt(i) + " ");
			}
			System.out.println();

			// allow guesses to be made till 7 have been made or a player has
			// guessed correctly
			boolean roundOn = true;
			while (guesses < MAX_GUESSES && roundOn) {
				// Determine if player wants to guess message or letter
				System.out.print(currentPlayer + ", you have used " + guesses
						+ " guesses, would you like to (1) solve or (2) guess a character: ");
				String inputChoice = keyboard.nextLine().trim();
				while (!(inputChoice.equals("1") || inputChoice.equals("2"))) {
					System.out.print(currentPlayer + ", you must enter (1) solve or (2) guess a character: ");
					inputChoice = keyboard.nextLine().trim();
				}

				// Player decides to solve message
				if (inputChoice.equals("1")) {
					System.out.print(currentPlayer + ", please enter your solution: ");
					// check if alphanumeric
					guess = checkIt(keyboard, currentPlayer);
					
					// evaluate if response is correct
					if (guess.equals(message)) {
						System.out.println(currentPlayer + ", you are correct!");
						roundOn = false;
						guesses--;
					} else {
						System.out.println(currentPlayer + ", you are unfortunately incorrect!");
					}

					// Player decides to guess a character
				} else if (inputChoice.equals("2")) {
					System.out.print("Unused Characters: ");
					for (int i = 0; i < possibleGuesses.length(); i++) {
						System.out.print(possibleGuesses.charAt(i) + " ");

					}
					System.out.print("\n" + currentPlayer + ", please guess a single character: ");
					// check if character is alphanumeric, has a length of 1,
					// and has not been used
					guess = checkIt(keyboard, currentPlayer);
					possibleGuesses = possibleGuesses.substring(STARTING_CHAR, possibleGuesses.indexOf(guess))
									+ "_" + possibleGuesses.substring(possibleGuesses.indexOf(guess) + ONE_CHAR_OVER);
						

					// check if guessed character is in the message
					if (message.indexOf(guess) != MISSING_INDEX) {
						System.out.println(currentPlayer + ", the character '" + guess + "' is in the string!");
						// reveal correctly guessed characters
						for (int i = 0; i < coded.length(); i++) {
							if (message.substring(i, i + ONE_CHAR_OVER).equals(guess))
								coded = coded.substring(STARTING_CHAR, i) + guess + coded.substring(i + ONE_CHAR_OVER);
						}
					} else {
						System.out.println(currentPlayer + ", the character '" + guess + "' is not in the string.");
					}

					// print out new coded message with spaces
					for (int i = 0; i < coded.length(); i++) {
						System.out.print(coded.charAt(i) + " ");
					}

					// check if all characters in the message have been guessed
					System.out.println();
					if (coded.indexOf("_") == MISSING_INDEX) {
						System.out.println("You have guessed all the letters in the phrase!");
						guesses--;
						roundOn = false;
					}

				}
				guesses++;
			}
			// last guess - player must enter a solution
			if (guesses == MAX_GUESSES) {
				System.out.print(currentPlayer + ", you have used up your guesses. Please enter your solution: ");
				// check if phrase is valid
				guess = checkIt(keyboard, currentPlayer);
				// determine if the guess is correct
				if (guess.equals(message)) {
					System.out.println("Correct");
				} else {
					System.out.println("Wrong");
					guesses++;

				}
			}

			// assign points to the respective players && increase rounds if
			// both players have gone
			if (turns % PLAYER_DECIDER == IS_PLAYER_1_TURN) {
				p1Points += MAX_POINTS - guesses;
			} else if (turns % PLAYER_DECIDER == IS_PLAYER_2_TURN) {
				p2Points += MAX_POINTS - guesses;
				rounds++;

			}

			// print out the player's points
			System.out.println("Total player points");
			System.out.println(p1Name + ": \t" + p1Points);
			System.out.println(p2Name + ": \t" + p2Points);

			// determine who wins, and if tie breaker is necessary
			if (turns % TURNS_IN_ROUND == FINISHED_ROUNDS && rounds > MAX_ROUNDS) {
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
			// increase the turns
			turns++;
		}
		// close keyboard
		keyboard.close();
	}
	public static String checkIt(Scanner keyboard, String player){
		boolean notChecked = true;
		String message = "";
		while (notChecked) {
			message = keyboard.nextLine().toUpperCase().trim();
			notChecked = false;
			if (message.length() < LENGTH_ONE) {
				System.out.print("ERROR --> " + player + ", please enter A message to be guessed: ");
				notChecked = true;
			}
			for (int i = 0; i < message.length(); i++) {
				if (ALPHANUMERALS.indexOf(message.charAt(i)) == MISSING_INDEX) {
					System.out.print("ERROR --> " + player
							+ ", please enter an ALPHANUMERIC message to be guessed: ");
					notChecked = true;
					break;
				}
			}
		}
		return message;
	}
}