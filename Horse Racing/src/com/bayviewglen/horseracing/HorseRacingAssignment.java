package com.bayviewglen.horseracing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HorseRacingAssignment {
	static Scanner keyboard = new Scanner(System.in);
	static final int STARTING_WALLET = 100;
	static final int FIRST_PART = 0;
	static final int SECOND_PART = 1;
	static final int ADJUST_TABLE_NUM = 1;
	static boolean playerAllLost = false;

	static final int SLOW = 2500;
	static final int MEDIUM = 1000;
	static final int FAST = 500;
	static final int SUPERFAST = 200;
	static int raceNumber = 1;
	public static void main(String[] args) {
		introMessage();
		String[] horses = getHorses();
		int[] ratings = getRatings();
		String[] playerNames = getPlayerNames();
		int[] playerWallets = getPlayerWallets(playerNames.length);
		boolean gameOver = false;
		while (!gameOver) {
			doRace(horses, ratings, playerNames, playerWallets);
			if (!playerAllLost)
				gameOver = promptForGameOver();
			else
				gameOver = true;
		}
		updatePlayerData(playerNames, playerWallets);
		closingMessage();

	}

	private static void introMessage() {
		System.out.println("Welcome to Aliqyan's Magnificant Horse Racing Parlour");
		sleep(FAST);
		System.out.println("We wish you the best of luck and hope you have lots of fun!");
		sleep(SLOW);
		lineSpacer(30);
	}

	private static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void lineSpacer(int lines) {
		for (int i = 0; i < lines; i++) {
			System.out.println();
		}
	}

	// reads all the names of the horses in the horses file
	public static String[] getHorses() {
		String[] horses = null;
		try {
			Scanner scanner = new Scanner(new File("input/horses.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];

			for (int i = 0; i < numHorses; i++) {
				// Take only the name of the horse, not the rating
				horses[i] = scanner.nextLine().split(":")[FIRST_PART];
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return horses;
	}

	// reads all the ratings of the horses in the horses file
	public static int[] getRatings() {
		int[] ratings = null;
		try {
			Scanner scanner = new Scanner(new File("input/horses.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			ratings = new int[numHorses];

			for (int i = 0; i < numHorses; i++) {
				// Take only the ratings of the horses
				ratings[i] = Integer.parseInt(scanner.nextLine().split(":")[SECOND_PART]);
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ratings;
	}

	// Gather all the players in the player file + those requested
	private static String[] getPlayerNames() {
		String[] playerNames = null;

		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());

			// ask for additional players
			ArrayList<String> additionalPlayerNames = getAdditionalPlayers(numPlayers);

			playerNames = new String[numPlayers + additionalPlayerNames.size()];

			for (int i = 0; i < playerNames.length; i++) {
				// add players in the file first, then add the additional
				// players, if there are any
				if (i < numPlayers) {
					playerNames[i] = (scanner.nextLine()).split(" ")[FIRST_PART];
				} else {
					playerNames[i] = additionalPlayerNames.get(i - numPlayers);
				}
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return playerNames;
	}

	// ask for any new players
	private static ArrayList<String> getAdditionalPlayers(int numPlayers) {
		ArrayList<String> additionalPlayerNames = new ArrayList<String>();
		System.out.println("***Please note that all new players begin with a standard $" + STARTING_WALLET + "***");
		boolean noPlayers = numPlayers == 0;
		if (noPlayers) {
			System.out.println("There are currently no players in this race.");
			System.out.println("Please register for this race");
		} else {
			System.out.print("Would you like to 1.Add Player, 2.Start Betting: ");
		}
		final int ADD_PLAYER = 1;
		while (noPlayers || getValidInput(1, 2) == ADD_PLAYER) {
			System.out.print("The name of the player is(we will only record the first name): ");
			additionalPlayerNames.add(keyboard.nextLine().split(" ")[FIRST_PART]);
			System.out.print("Would you like to 1.Add Player, 2.Start Betting: ");
			noPlayers = false;
		}
		System.out.println("No more players can be added during today's racess. Please wait until tomorrow.");
		sleep(MEDIUM);
		return additionalPlayerNames;
	}

	// Gather amount players have + add a standard amount to new players
	private static int[] getPlayerWallets(int numPlayers) {
		int[] playerWallets = null;
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPreviousPlayers = Integer.parseInt(scanner.nextLine());
			playerWallets = new int[numPlayers];
			for (int i = 0; i < numPlayers; i++) {
				// add amount previously owned unless it is a new player
				if (i < numPreviousPlayers)
					playerWallets[i] = Integer.parseInt((scanner.nextLine()).split(" ")[SECOND_PART]);
				else
					playerWallets[i] = STARTING_WALLET;
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return playerWallets;
	}

	private static void doRace(String[] horses, int[] ratings, String[] playerNames, int[] playerWallets) {
		// horsesInRace contains the index of the horses from the horse array
		int[] horsesInRace = getHorsesInRace(horses);

		// 2d array with column 0 = bet amount, column 1 = horseIndex(from
		// horsesInRace)
		int[][] playerBets = getPlayerBets(playerNames, playerWallets, horsesInRace, horses, ratings);

		// an Array List because number of horses passing finish at the same
		// time is unknown
		ArrayList<Integer> winningHorse = startRace(horsesInRace, horses, ratings);

		payOutBets(playerBets, playerWallets, playerNames, winningHorse, ratings);
		if (checkContinuation(playerWallets)) {
			playerAllLost = true;
			System.out.println(
					"As all of the players have lost all of their money, we will be terminating this event early.");
			sleep(SLOW);
			
		}
	}

	// Randomly pick 5-8 horses to be in the race from horses array
	private static int[] getHorsesInRace(String[] horses) {
		final int MIN_NUM_HORSES = 5;
		final int RANGE_NUM_HORSES = 4;
		// pick random number of horses
		int numRaceHorses = (int) (Math.random() * RANGE_NUM_HORSES + MIN_NUM_HORSES);
		// store the index of the horse in the horse array
		int[] horsesInRace = new int[numRaceHorses];
		for (int i = 0; i < numRaceHorses; i++) {
			int randomIndex = (int) (Math.random() * horses.length);
			// check if horse is already in race, if yes choose a new horse
			while (alreadyInRace(randomIndex, horsesInRace)) {
				randomIndex = (int) (Math.random() * horses.length);
			}
			horsesInRace[i] = randomIndex;
		}
		return horsesInRace;
	}

	// Check if horse is already in race: Credits to Mr. Deslauriers for the
	// method
	// if method returns true than a new horse must be picked as it's in the
	// race
	public static boolean alreadyInRace(int horse, int[] horsesInRace) {

		for (int i = 0; i < horsesInRace.length; i++) {
			if (horsesInRace[i] == horse) {
				return true;
			}
		}

		return false;
	}

	private static int[][] getPlayerBets(String[] playerNames, int[] playerWallets, int[] horsesInRace, String[] horses,
			int[] ratings) {
		int[][] playerBets = new int[playerNames.length][2];

		// specifically for the playerBets array
		final int BET_AMOUNT = 0;
		final int HORSE_BETTED = 1;

		final int MIN_BET = 1;
		displayPlayers(playerNames, playerWallets);
		boolean keepBetting = true;
		while (keepBetting) {
			System.out.print("Choose Player: ");
			// make sure the player exists
			int playerChoice = 0;
			boolean validChoice = false;
			// check if the player is able to bet: he hasn't made a bet before
			// and he isn't broke
			while (!validChoice) {
				playerChoice = getValidInput(1, playerNames.length) - ADJUST_TABLE_NUM;
				if (playerBets[playerChoice][BET_AMOUNT] != 0) {
					System.out.print(playerNames[playerChoice]
							+ ", you cannot bet more than once in a race, please choose another player: ");
				} else if (playerWallets[playerChoice] == 0) {
					System.out
							.println("Sorry " + playerNames[playerChoice] + ", you cannot bet because you are broke.");
					System.out.println("Please choose another player: ");
				} else {
					validChoice = true;
				}

			}
			// find out how much player wants to bet, and validate the bet
			System.out.println("Hello " + playerNames[playerChoice]);
			System.out.print("How much would you like to bet, you have $" + playerWallets[playerChoice] + "? ");
			playerBets[playerChoice][BET_AMOUNT] = getValidInput(MIN_BET, playerWallets[playerChoice]);
			System.out.print("Which horse would you like to bet on?(enter 0 if you want to see the list of horses) ");
			int choice = getValidInput(0, horsesInRace.length);
			if (choice == 0) {
				diplayHorses(horsesInRace, horses, ratings);
				System.out.print("Which horse would you like to bet on? ");
				choice = getValidInput(1, horsesInRace.length);
			}
			playerBets[playerChoice][HORSE_BETTED] = choice;
			boolean allBetted = true;
			for (int i = 0; i < playerNames.length; i++) {
				if (playerBets[i][0] == 0) {
					allBetted = false;
					break;
				}
			}
			if (!allBetted) {
				System.out.print("Option(1.Bet, 2. Start Race): ");
				if (getValidInput(1, 2) == 2) {
					keepBetting = false;
					sleep(MEDIUM);
				}
			} else {
				System.out.print("All the players have made bets, It's time to race! ");
				keepBetting = false;
				sleep(MEDIUM);
			}
		}
		return playerBets;

	}

	// display the players in a table
	private static void displayPlayers(String[] playerNames, int[] playerWallets) {
		System.out.println("");
		System.out.printf("%s" + "|" + "%-20s" + "|" + "%-10s|\n", "#", "Player Name", "Wallet");
		System.out.println("-|--------------------|----------|");
		for (int j = 0; j < playerNames.length; j++) {
			System.out.printf("%d" + "|" + "%-20s|%10.2f" + "|\n", j + ADJUST_TABLE_NUM, playerNames[j],
					(double) playerWallets[j]);
			System.out.println("-|--------------------|----------|");
		}
	}

	// display the horses in a table
	private static void diplayHorses(int[] horsesInRace, String[] horses, int[] ratings) {
		System.out.printf("%s" + "|" + "%-20s" + "-%10s" + "|\n", "#", "Horse Name", "Ratings");
		System.out.println("-|--------------------|----------|");
		for (int j = 0; j < horsesInRace.length; j++) {
			String ratingStars = "";
			for (int i = 0; i < ratings[horsesInRace[j]]; i++) {
				ratingStars += "*";
			}
			System.out.printf("%d" + "|" + "%-20s" + "|" + "%-10s" + "|\n", j + ADJUST_TABLE_NUM,
					horses[horsesInRace[j]], ratingStars);
			System.out.println("-|--------------------|----------|");

		}
	}

	// make sure that the input is between the valid range, and that the input
	// is a number
	public static int getValidInput(int min, int max) {
		boolean isValid = false;
		int x = 0;
		while (!isValid) {
			try {
				x = Integer.parseInt(keyboard.nextLine());
				if (x >= min && x <= max)
					isValid = true;
				else
					System.out.print("Please enter a whole number between " + min + " and " + max + ": ");
			} catch (Exception ex) {
				System.out.print("Please enter a number between " + min + " and " + max + ": ");
			}
		}

		return x;
	}

	// show the race
	private static ArrayList<Integer> startRace(int[] horsesInRace, String[] horses, int[] ratings) {
		boolean raceOver = false;
		final int ARRAY_ELEMENT_ADJUSTER = 1;
		int[] spaces = new int[horsesInRace.length];
		double[] maxSpaces = { 4, 4.5, 5, 5.5, 6 };
		ArrayList<Integer> winningHorse = new ArrayList<>();
		// must initialize with one so that there is enough space of the horse
		// number
		System.out.println("\nIt is now time to commence Race # " + raceNumber++ + " in: ");
		sleep(MEDIUM);
		for(int i = 3; i >=0; i--){
			if(i == 0){
				System.out.println("GO!!!");
			}else{
				System.out.println(i);
			}
			sleep(MEDIUM);

		}
		
		for (int i = 0; i < horsesInRace.length; i++) {
			spaces[i] = 1;
		}
		// print the race
		while (!raceOver) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(
					"--------------------|--------------------------------------------------------------------------------");
			// if a horse finishes keep track of the horse/s and end the race
			for (int i = 0; i < horsesInRace.length; i++) {
				if (spaces[i] >= 80) {
					winningHorse.add(horsesInRace[i]);
					raceOver = true;
				}

				String format = "%" + spaces[i] + "d";
				System.out.printf("%20s" + "|" + format + "\n", horses[horsesInRace[i]], i + ADJUST_TABLE_NUM);
				System.out.println(
						"--------------------|--------------------------------------------------------------------------------");

				spaces[i] += (int) (Math.random() * maxSpaces[ratings[horsesInRace[i]] - ARRAY_ELEMENT_ADJUSTER]);
			}
			System.out.println();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println("The following horses have won: ");
		for (int i = 0; i < winningHorse.size(); i++) {
			System.out.println("\t -->" + horses[winningHorse.get(i)]);
		}
		return winningHorse;
	}

	// pay out the bets,or take the money form the players away
	private static void payOutBets(int[][] playerBets, int[] playerWallets, String[] playerNames,
			ArrayList<Integer> winningHorse, int[] ratings) {
		double[] ratingsMultiplier = { 2, 1.25, 1, 0.75, 0.5 };
		for (int i = 0; i < playerNames.length; i++) {
			if (playerBets[i][1] != 0) {
				boolean hasWon = false;
				for (int j = 0; j < winningHorse.size(); j++) {
					if (playerBets[i][1] == (int) winningHorse.get(j)) {
						Double reward = playerBets[i][0] * ratingsMultiplier[ratings[(int) winningHorse.get(j)]];
						playerWallets[i] += reward;
						hasWon = true;
						System.out.println("Congratulations " + playerNames[i] + ", you have earned $" + reward);
						break;
					}
				}
				if (!hasWon) {
					playerWallets[i] -= playerBets[i][0];
					System.out.println("Sorry " + playerNames[i] + ", you have lost $" + playerBets[i][0]);
				}
			}
		}
	}

	// check if all the players are broke, if yes end the game
	private static boolean checkContinuation(int[] playerWallets) {
		for (int i = 0; i < playerWallets.length; i++) {
			if (playerWallets[i] >= 1)
				return false;
		}
		return true;
	}

	// ask if game will end
	private static boolean promptForGameOver() {
		System.out.print("Would you like to end the game, please enter either yes or no: ");
		String response = keyboard.nextLine();
		return checkYesNo(keyboard, response);

	}

	// checker for if the game chould be over, ensures either yes or no is
	// selected
	private static boolean checkYesNo(Scanner keyboard, String message) {
		while (!(message.toLowerCase().equals("yes") || message.toLowerCase().equals("no"))) {
			System.out.print("Please enter either yes or no:");
			message = keyboard.nextLine();
		}
		return message.toLowerCase().equals("yes");
	}

	// writes new data to the player file, removes any broke players
	private static void updatePlayerData(String[] playerNames, int[] playerWallets) {
		FileWriter fw;
		try {
			fw = new FileWriter(new File("input/player.dat"));
			if (!playerAllLost) {
				int numCurrPlayers = playerNames.length;
				for (int i = 0; i < playerNames.length; i++) {
					if (playerWallets[i] == 0) {
						System.out.println("Sorry " + playerNames[i]
								+ ", you are broke, we are terminating your membership, please sign up next time and you will start with $"
								+ STARTING_WALLET + ".");
						numCurrPlayers--;
					}
				}
				fw.write(numCurrPlayers + "\n");

				for (int i = 0; i < playerNames.length; i++) {
					if (playerWallets[i] != 0)
						fw.write(playerNames[i] + " " + playerWallets[i] + "\n");
				}
			}else{
				fw.write(0 + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// message at the end of the race
	private static void closingMessage() {
		System.out.println("Thank you for playing at Aliqyan's Magnifient Horse Racing Parlour!");
		System.out.println("We hope to see you soon!");
	}
}