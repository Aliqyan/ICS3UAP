package com.bayviewglen.hangman;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		// Declaring final variables
		final String ALPHANUMERALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
		final String ALPHANUMERALS_NO_SPACES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final int MAX_POINTS = 8;
		final int MAX_GUESSES = 7;
		final int PLAYER_DECIDER = 2;
		final int IS_PLAYER_1_TURN = 1;
		final int IS_PLAYER_2_TURN = 0;
		final int MISSING_INDEX = -1;
		final int ONE_CHAR_OVER = 1;
		final int NUM_SPACE_LINES = 30;
		final int STARTING_CHAR = 0;
		final int MAX_ROUNDS = 10;
		
		String possibleGuesses = "";
		String message = null;
		String guess = null;
		String currentPlayer = null;
		String opposingPlayer = null;
		String coded = null;
		int p1Points = 0;
		int p2Points = 0;
		int guesses;
		int rounds = 1;
		
		//prompt player for names
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Player One, Please enter your first name: ");
		String p1Name = keyboard.nextLine();

		System.out.print("Player Two, Please enter your first name: ");
		String p2Name = keyboard.nextLine();
		
		//run the loop until a player wins for a maximum of 10 times 
		boolean gameOver = false;
		while (!gameOver) {
			System.out.println("------------------------- Round " + rounds + " ------------------------- ");
			possibleGuesses = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			guesses = 0;
			coded = "";
			
			//determine each players roles 
			if (rounds % PLAYER_DECIDER == IS_PLAYER_1_TURN) {
				currentPlayer = p1Name;
				opposingPlayer = p2Name;
			} else if (rounds % PLAYER_DECIDER == IS_PLAYER_2_TURN) {
				currentPlayer = p2Name;
				opposingPlayer = p1Name;
			}

			System.out.print(opposingPlayer + ", please enter an alphanumeric message to be guessed: ");
			message = keyboard.nextLine().toUpperCase();
			//check if only alphanumeric characters used 
			boolean notChecked = true;
			while (notChecked) {
				notChecked = false;
				for (int i = 0; i < message.length(); i++) {
					if (ALPHANUMERALS.indexOf(message.charAt(i)) == MISSING_INDEX) {
						System.out.print("ERROR --> " + opposingPlayer
								+ ", please enter an ALPHANUMERIC message to be guessed: ");
						message = keyboard.nextLine().toUpperCase();
						notChecked = true;
					}
				}
			}
			
			for (int i = 0; i < NUM_SPACE_LINES; i++)
				System.out.println();
			
			//encode the message
			for (int i = 0; i < message.length(); i++) {
				if (message.charAt(i) == ' ')
					coded += "/";
				else
					coded += "_";
			}
			//print the coded message with spaces in between the coded characters
			for(int i = 0; i < coded.length();i++){
				System.out.print(coded.charAt(i) + " ");
			}
			System.out.println();
			
			//allow guesses to be made till 7 have been made or a player has guessed correctly 
			boolean roundOn = true;
			while (guesses < MAX_GUESSES && roundOn) {
				//Determine if player wants to guess message or letter
				System.out.print(currentPlayer + ", you have used " + guesses
						+ " guesses, would you like to (1) solve or (2) guess a character: ");
				String inputChoice = keyboard.nextLine();
				while (!(inputChoice.equals("1") || inputChoice.equals("2"))) {
					System.out.print(currentPlayer + ", you must enter (1) solve or (2) guess a character: ");
					inputChoice = keyboard.nextLine();
				}
				
				//to solve message
				if (inputChoice.equals("1")) {
					System.out.print(currentPlayer + ", please enter your solution: ");
					guess = keyboard.nextLine().toUpperCase();
					//check alpha numeric
					notChecked = true;
					while (notChecked) {
						notChecked = false;
						for (int i = 0; i < guess.length(); i++) {
							if (ALPHANUMERALS.indexOf(guess.charAt(i)) == MISSING_INDEX) {
								System.out.print(
										"ERROR --> " + currentPlayer + ", please enter an ALPHANUMERIC solution: ");
								guess = keyboard.nextLine().toUpperCase();
								notChecked = true;
							}
						}
					}
					//evaluate response
					if (guess.equals(message)) {
						System.out.println(currentPlayer + ", you are correct!");
						roundOn = false;
					} else {
						System.out.println(currentPlayer + ", you are unfortunately incorrect!");
						guesses++;
					}
				// to solve for character guess
				} else if (inputChoice.equals("2")) {
					System.out.print("Unused Characters: ");
					for (int i = 0; i < possibleGuesses.length(); i++) {
						System.out.print(possibleGuesses.charAt(i) + " ");

					}
					System.out.print("\n" + currentPlayer + ", please guess a single character: ");
					guess = keyboard.nextLine().toUpperCase();
					//check if character is alphanumeric && length of 1 && not used prior
					notChecked = true;
					while (notChecked) {
						if (ALPHANUMERALS_NO_SPACES.indexOf(guess) == MISSING_INDEX) {
							System.out.print("ERROR --> " + currentPlayer
									+ ", please either guess a letter or the message(using  ALPHANUMERIC charcters): ");
							guess = keyboard.nextLine().toUpperCase();
						}else if (guess.length() > 1){
							System.out.print("ERROR --> " + currentPlayer + ", please guess A letter: "); 
							guess = keyboard.nextLine().toUpperCase();
						}else if (possibleGuesses.indexOf(guess) == MISSING_INDEX) {
							System.out.print("ERROR --> " + currentPlayer
									+ ", please either guess a letter or the message(THAT YOU HAVEN'T BEFORE): ");
							guess = keyboard.nextLine().toUpperCase();
						} else {
							notChecked = false;
							possibleGuesses = possibleGuesses.substring(STARTING_CHAR, possibleGuesses.indexOf(guess)) + "_"
									+ possibleGuesses.substring(possibleGuesses.indexOf(guess) + ONE_CHAR_OVER);
						}
					

					}
					
					// reveal correctly guessed characters
					
					
					//check if guessed character is in the message
					if(message.indexOf(guess) != MISSING_INDEX){
						System.out.println(currentPlayer + ", the character '" + guess + "' is in the string!");
						// reveal correctly guessed characters
						for(int i = 0; i < coded.length(); i++){					
							if (message.substring(i, i + ONE_CHAR_OVER).equals(guess)) 
								coded = coded.substring(STARTING_CHAR, i) + guess + coded.substring(i + ONE_CHAR_OVER);
						}	
					}else{
						System.out.println(currentPlayer + ", the character '" + guess + "' is not in the string.");
					}
					
					//print out new coded message with spaces
					for(int i = 0; i < coded.length();i++){
						System.out.print(coded.charAt(i) + " ");
					}
					System.out.println();
					
					guesses++;
				}
			}
			// last guess - player must enter a solution
			if (guesses == MAX_GUESSES) {
				System.out.print(currentPlayer + ", you have used up your guesses. Please enter your solution: ");
				guess = keyboard.nextLine().toUpperCase();
				notChecked = true;
				while (notChecked) {
					notChecked = false;
					for (int i = 0; i < guess.length(); i++) {
						if (ALPHANUMERALS.indexOf(message.charAt(i)) == MISSING_INDEX) {
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
					guesses++;
				}
			}
			
			//assign points to respective players
			if (rounds % PLAYER_DECIDER == IS_PLAYER_1_TURN)
				p1Points += MAX_POINTS - guesses;
			else if (rounds % PLAYER_DECIDER == IS_PLAYER_2_TURN)
				p2Points += MAX_POINTS - guesses;

			System.out.println("Total player points");
			System.out.println(p1Name + ": \t" + p1Points);
			System.out.println(p2Name + ": \t" + p2Points);
			
			//determine who wins, and if tie breaker is necessary
			if (rounds >= MAX_ROUNDS) {
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
