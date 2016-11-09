package com.bayviewglen.hangman;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		final String alphanumerals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Player One, Please enter your first name: ");
		String p1Name = keyboard.nextLine();

		System.out.print("Player Two, Please enter your first name: ");
		String p2Name = keyboard.nextLine();

		String message = "";
		String guess = "";
		String lettersGuessed = "";
		String currentPlayer = null;
		String opposingPlayer = null;
		String coded = "";
		int p1Points = 0;
		int p2Points = 0;
		int roundPoints = 0;
		int guesses;
		
	
		for (int n = 0; n < 10; n++) {
			roundPoints = 0;
			if (n % 2 == 0) {
				currentPlayer = p1Name;
				opposingPlayer = p2Name;
				
			} else if (n % 2 == 1) {
				currentPlayer = p2Name;
				opposingPlayer = p1Name;
			}
			System.out.print(opposingPlayer + ", please enter an alphanumeric message to be guessed: ");
			message = keyboard.nextLine().toUpperCase();
			System.out.println(message);

			for (int i = 0; i < message.length(); i++) {
				if (alphanumerals.indexOf(message.charAt(i)) == -1) {
					System.out.print("ERROR --> " + opposingPlayer + ", please enter an ALPHANUMERIC message to be guessed: ");
					message = keyboard.nextLine().toUpperCase();
					i = 0;
				}
			}

			for (int i = 0; i < message.length(); i++) {
				if (message.charAt(i) == ' ') coded += "/ ";
				else coded += "_ ";
			}

			System.out.println(coded);
			guesses = 7;
			
			while (guesses > 0) {
				System.out.print(currentPlayer + ", please either guess a letter or the message: ");
				guess = keyboard.nextLine().toUpperCase();
				for (int i = 0; i < guess.length(); i++) {
					if (alphanumerals.indexOf(guess.charAt(i)) == -1) {
						System.out.print("ERROR --> " + currentPlayer
								+ ", please either guess a letter or the message(using  ALPHANUMERIC charcters): ");
						guess = keyboard.nextLine().toUpperCase();
						i --;
					}else if(lettersGuessed.indexOf(guess.charAt(i)) != -1){
						System.out.print("ERROR --> " + currentPlayer
								+ ", please either guess a letter or the message(THAT YOU HAVEN'T BEFORE): ");
						guess = keyboard.nextLine().toUpperCase();
						i --;
					}
				}
				if (guesses == 1) {
					System.out.print(currentPlayer + ", you have one last chance to guess the word correctly:");
					guess = keyboard.nextLine().toUpperCase();
					if (guess.equals(message)) {
						System.out.println("Correct");
						break;
					} else {
						System.out.println("Wrong");
					}
				} else if (guess.equals(message)) {
					System.out.println("Correct");
					break;
				} else if (guess.length() == 1) {
					for (int i = 0; i < message.length(); i++) {
						if (message.substring(i, i + 1).equals(guess)) {
							coded = coded.substring(0, 2 * i) + guess + coded.substring(2 * i + 1);
						}
					}
					lettersGuessed += guess;
					System.out.println(coded);
					System.out.println("You have already used these letters: " + lettersGuessed);
				
				}
				guesses--;
				System.out.println("You have " + guesses + " guesses left.");
			}
			if (n % 2 == 0) {
				p1Points += guesses;
				System.out.println("Congrats " + currentPlayer + " you have earned " + roundPoints + " bringing your total points up to "  + p1Points);
			} else if (n % 2 == 1) {
				p2Points += guesses;
				System.out.println("Congrats " + currentPlayer + " you have earned " + roundPoints + " bringing your total points up to "  + p2Points);
			}

		}
		if(p1Points > p2Points){
			System.out.println("Congratulations " + p1Name + ", you won!!");
		}else if(p1Points < p2Points){
			System.out.println("Congratulations " + p2Name + ", you won!!");
		}else{
			System.out.println("Congratulations, you tie!!!");
		}


		keyboard.close();
	}

}
