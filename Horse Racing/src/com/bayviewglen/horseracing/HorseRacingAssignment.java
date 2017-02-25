package com.bayviewglen.horseracing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HorseRacingAssignment {
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		introMessage();
		String[] horses = getHorses();
		int[] ratings = getRatings();
		
		String[] playerNames = getPlayerNames();
		int[] playerWallets = getPlayerWallets();
		boolean gameOver = false;
		while (!gameOver) {
			doRace(horses, ratings, playerNames, playerWallets);
			gameOver = promptForGameOver();
		}

		updatePlayerData(playerNames, playerWallets);
		closingMessage();
	}

	private static void introMessage()  {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Aliqyan's Magnificant Horse Racing Parlour");
		System.out.println("Please note: only educated guesses are allowed as betting is HARAM, wink wink");
	}

	/*
	 * Reads the horses from a file assume the file exists and is in the format
	 * specified in the assignment.
	 */
	public static String[] getHorses() {
		String[] horses = null;
		try {
			Scanner scanner = new Scanner(new File("input/horses.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];
	
			for (int i = 0; i < numHorses; i++) {
				horses[i] = scanner.nextLine().split(":")[0];
			}
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return horses;
	}

	public static int[] getRatings() {
		int[] ratings = null;
		try {
			Scanner scanner = new Scanner(new File("input/horses.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			ratings = new int[numHorses];
	
			for (int i = 0; i < numHorses; i++) {
				ratings[i] = Integer.parseInt(scanner.nextLine().split(":")[1]);
			}
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return ratings;
	}
	
	private static String[] getPlayerNames() {
		String[] playerNames = null;
		ArrayList <String> additionalPlayerNames = new ArrayList<String>();
		System.out.print("Would you like to 1.Add Player, 2.Start Betting: ");
		while(getValidInput(1,2) == 1){
			System.out.print("The name of the player is(we will only record the first name): " );
			additionalPlayerNames.add(keyboard.nextLine().split(" ")[0]);
			System.out.print("Would you like to 1.Add Player, 2.Start Betting: ");

		}
		System.out.println("No more players can be added to this race. Please wait until the next race.");
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			playerNames = new String[numPlayers + additionalPlayerNames.size()];
	
			for (int i = 0; i < playerNames.length; i++) {
				if(i < numPlayers){
					playerNames[i] = (scanner.nextLine()).split(" ")[0];
				}else{
					playerNames[i] = additionalPlayerNames.get(i-numPlayers);
				}
			}
			
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return playerNames;
	}

	private static int[] getPlayerWallets() {
		int[] playerWallets = null;
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			playerWallets = new int[numPlayers];
	
			for (int i = 0; i < numPlayers; i++) {
				if(i < numPlayers)
					playerWallets[i] = Integer.parseInt((scanner.nextLine()).split(" ")[1]);
				else
					playerWallets[i] = 100;
			}
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return playerWallets;
	}

	private static void doRace(String[] horses, int[] ratings, String[] playerNames, int[] playerWallets) {
		// TODO Auto-generated method stub
		// horsesInRace contains the index of the horses from the master horse
		// array
		int[] horsesInRace = getHorsesInRace(horses);
		// 2d array with column 0 = bet amount, column 1 = horseIndex(from
		// horsesInRace)
		
		int[][] playerBets = getPlayerBets(playerNames, playerWallets, horsesInRace, horses, ratings);
		for(int i = 0; i< playerBets.length; i++){
			System.out.println(playerBets[i][0] + "\t" + playerBets[i][1]);
	    }
		//
		ArrayList winningHorse = startRace(horsesInRace, horses, ratings);
	
		payOutBets(playerBets, playerWallets, playerNames, winningHorse, ratings);
	}

	private static int[] getHorsesInRace(String[] horses) {
		// TODO Auto-generated method stub
		int numRaceHorses = (int) (Math.random() * 4 + 5);
		int[] horsesInRace = new int[numRaceHorses];
		for (int i = 0; i < numRaceHorses; i++) {
			int randomIndex = (int) (Math.random() * horses.length);
			while (alreadyInRace(randomIndex, horsesInRace)) {
				randomIndex = (int) (Math.random() * horses.length);
			}
			horsesInRace[i] = randomIndex;
	
		}
		return horsesInRace;
	}

	private static int[][] getPlayerBets(String[] playerNames, int[] playerWallets, int[] horsesInRace, String[] horses, int[] ratings) {
		// TODO Auto-generated method stub
		int[][] playerBets = new int [playerNames.length][2];
		displayPlayers(playerNames, playerWallets);
		boolean keepBetting = true;
		while(keepBetting){
			System.out.print("Choose Player: ");
			int playerChoice = getValidInput(1, playerNames.length) - 1;
			while(playerBets[playerChoice][0] != 0){
				System.out.print("You cannot bet more than once in a race, please choose another player: ");
				 playerChoice = getValidInput(1, playerNames.length) - 1;
			}
			System.out.println("Hello " + playerNames[playerChoice]);
			System.out.print("How much would you like to bet, you have $" + playerWallets[playerChoice] + "? ");
			playerBets[playerChoice][0] = getValidInput(0,  playerWallets[playerChoice]);
			System.out.print("Which horse would you like to bet on?(enter 0 if you want to see the list of horses) ");
			int choice = getValidInput(0,  horsesInRace.length);
			if(choice == 0){
				diplayHorses(horsesInRace, horses, ratings);
				System.out.print("Which horse would you like to bet on? ");
				choice = getValidInput(1,  horsesInRace.length);
			}
			playerBets[playerChoice][1] = choice;
			System.out.println("Option(1.Bet, 2. Start Race):" );
			if(getValidInput(1,2) == 2) keepBetting = false;
		}
		return playerBets;

	}

	private static void displayPlayers(String[] playerNames, int[] playerWallets) {
		System.out.println("");
		System.out.printf("%s" + "|" + "%-20s" + "|" + "%-10s|\n", "#", "Player Name", "Wallet");
		System.out.println("-|--------------------|----------|");
		for(int j =0; j<playerNames.length; j++){
			
			System.out.printf("%d" + "|" + "%-20s|%10.2f" + "|\n", j+1, playerNames[j], (double)playerWallets[j]);
			System.out.println("-|--------------------|----------|");
		}
	}

	private static void diplayHorses(int[] horsesInRace, String[] horses, int[] ratings) {
		// TODO Auto-generated method stub
		System.out.printf("%s" + "|" + "%-20s" + "-%10s" + "|\n", "#", "Horse Name", "Ratings");
		System.out.println("-|--------------------|----------|");
		for(int j =0; j<horsesInRace.length; j++){
			String ratingStars = "";
			for(int i = 0; i < ratings[horsesInRace[j]] ;i++){
				ratingStars += "*";
			}
			System.out.printf("%d" + "|" + "%-20s" + "|" + "%-10s" + "|\n", j+1, horses[horsesInRace[j]], ratingStars);
			System.out.println("-|--------------------|----------|");
			
		}
	}

	public static int getValidInput(int min, int max){
		boolean isValid = false;
		int x = 0;
		while(!isValid){
			try{
				x = Integer.parseInt(keyboard.nextLine());
				if (x>=min && x<=max) 
					isValid = true;
				else System.out.print("Please enter a number between " + min + " and " + max + ": ");
			}catch(Exception ex){
				System.out.print("Please enter a number between " + min + " and " + max + ": ");
			}
		}
		
		return x;
	}

	private static ArrayList<Integer> startRace(int[] horsesInRace, String[] horses, int[] ratings) {
		// TODO Auto-generated method stub
		boolean raceOver = false;
		int[] spaces = new int[horsesInRace.length];
		double[] maxSpaces = {4,4.5,5,5.5,6};
		ArrayList <Integer> winningHorse = new ArrayList<>();
		for(int i = 0; i<horsesInRace.length; i++){
			spaces[i] = 1;
		}
		while(!raceOver){
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("--------------------|--------------------------------------------------------------------------------");
			for(int i = 0; i<horsesInRace.length;i++){
				if(spaces[i] >= 80){
					winningHorse.add(horsesInRace[i]);
					raceOver = true;
				}
				
				String format = "%" + spaces[i] + "d";
				System.out.printf("%20s" + "|" + format + "\n", horses[horsesInRace[i]], i+1);
				System.out.println("--------------------|--------------------------------------------------------------------------------");
				

				spaces[i] += (int)(Math.random() * maxSpaces[ratings[horsesInRace[i]]-1]);
				//System.out.print(spaces[i] + ", " );
			}
			System.out.println();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
		for(int i = 0; i<winningHorse.size(); i++){
			System.out.println(horses[winningHorse.get(i)]);
		}
		return winningHorse;
	}

	private static void updatePlayerData(String[] playerNames, int[] playerWallets) {
		FileWriter fw;
		try {
			fw = new FileWriter(new File("input/player.dat"));
			fw.write(playerNames.length + "\n");

			for(int i = 0; i < playerNames.length; i++){
				fw.write(playerNames[i] + " " + playerWallets[i] + "\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean promptForGameOver() {
		System.out.print("Would you like to end the game, enter either yes or no: ");
		String response = keyboard.nextLine();
		return checkYesNo(keyboard, response);

	}

	private static boolean checkYesNo(Scanner keyboard, String message) {
		// TODO Auto-generated method stub
		while (!(message.toLowerCase().equals("yes") || message.toLowerCase().equals("no"))) {
			System.out.print("Please enter either yes or no:");
			message = keyboard.nextLine();
		}
		return message.toLowerCase().equals("yes");
	}

	private static void payOutBets(int[][] playerBets, int[] playerWallets, String[] playerNames, ArrayList winningHorse, int[] ratings) {
		// TODO Auto-generated method stub
		double[] ratingsMultiplier = {2,1.25,1, 0.75, 0.5};
		for(int i = 0; i<playerNames.length; i++){
			if(playerBets[i][1] != -1){
				boolean hasWon = false;
				for(int j = 0; j < winningHorse.size(); j++){
					if(playerBets[i][1] == (int) winningHorse.get(j)){
						playerWallets[i] += playerBets[i][0] * ratingsMultiplier[ratings[(int) winningHorse.get(j)]];
						hasWon = true;
						break;
					}
				}
				if(!hasWon){
					playerWallets[i] -= playerBets[i][0];
				}
			}
		}
	}

	private static void closingMessage() {
		// TODO Auto-generated method stub
	
	}

	/*
	 * Check if a horse is already in the race - uses a modified search method
	 */
	public static boolean alreadyInRace(int horse, int[] horsesInRace) {

		for (int i = 0; i < horsesInRace.length; i++) {
			if (horsesInRace[i] == horse) {
				return true;
			}
		}

		return false;
	}
}



















/*package com.bayviewglen.horseracing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HorseRacingAssignment {
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		introMessage();
		String[] horses = getHorses();
		ArrayList<String> playerNames = getPlayerNames();
		int[] playerWallets = getPlayerWallets();
		for (int i = 0; i < playerNames.size(); i++) {
			System.out.println(playerNames.get(i) + "\t\t" + playerWallets[i]);
		}
		boolean gameOver = false;
		while (!gameOver) {
			doRace(horses, playerNames, playerWallets);
			gameOver = promptForGameOver();
		}

		updatePlayerData(playerNames, playerWallets);
		closingMessage();
	}

	private static void introMessage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Aliqyan's Magnificant Horse Racing Parlour");
		System.out.println("Please note: only educated guesses are allowed as betting is HARAM, wink wink");
	}

	
	public static String[] getHorses() {
		String[] horses = null;
		try {
			Scanner scanner = new Scanner(new File("input/horses.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];
	
			for (int i = 0; i < numHorses; i++) {
				horses[i] = scanner.nextLine();
			}
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return horses;
	}

	private static ArrayList<String> getPlayerNames() {
		ArrayList<String>playerNames = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());	
	
			for (int i = 0; i < numPlayers; i++) {
				playerNames.add((scanner.nextLine()).split(" ")[0]);
			}
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return playerNames;
	}

	private static int[] getPlayerWallets() {
		int[] playerWallets = null;
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			playerWallets = new int[numPlayers];
	
			for (int i = 0; i < numPlayers; i++) {
				playerWallets[i] = Integer.parseInt((scanner.nextLine()).split(" ")[1]);
			}
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return playerWallets;
	}

	private static void doRace(String[] horses, ArrayList<String> playerNames, int[] playerWallets) {
		// TODO Auto-generated method stub
		// horsesInRace contains the index of the horses from the master horse
		// array
		int[] horsesInRace = getHorsesInRace(horses);
		// 2d array with column 0 = bet amount, column 1 = horseIndex(from
		// horsesInRace)
		
		int[][] playerBets = getPlayerBets(playerNames, playerWallets, horsesInRace, horses);
		for(int i = 0; i< playerBets.length; i++){
			System.out.println(playerBets[i][0] + "\t" + playerBets[i][1]);
	    }
	
		int winningHorse = startRace(horsesInRace, horses);
	
		payOutBets(playerBets, playerWallets, playerNames, winningHorse);
	}

	private static int[] getHorsesInRace(String[] horses) {
		// TODO Auto-generated method stub
		int numRaceHorses = (int) (Math.random() * 4 + 5);
		int[] horsesInRace = new int[numRaceHorses];
		for (int i = 0; i < numRaceHorses; i++) {
			int randomIndex = (int) (Math.random() * horses.length);
			while (alreadyInRace(randomIndex, horsesInRace)) {
				randomIndex = (int) (Math.random() * horses.length);
			}
			horsesInRace[i] = randomIndex;
	
		}
		return horsesInRace;
	}

	private static int[][] getPlayerBets(ArrayList<String> playerNames, int[] playerWallets, int[] horsesInRace, String[] horses) {
		// TODO Auto-generated method stub
		// insert chart with player names and wallet amount
		// insert chart with all of the horses
		int[][] playerBets = new int [playerNames.size()][2];
		displayPlayers(playerNames, playerWallets);
		boolean keepBetting = true;
		while(keepBetting){
			System.out.print("Choose Player: ");
			int playerChoice = getValidInput(1, playerNames.size()) - 1;
			while(playerBets[playerChoice][0] != 0){
				System.out.print("You cannot bet more than once in a race, please choose another player: ");
				 playerChoice = getValidInput(1, playerNames.size()) - 1;
			}
			System.out.println("Hello " + playerNames.get(playerChoice));
			System.out.print("How much would you like to bet, you have $" + playerWallets[playerChoice] + "? ");
			playerBets[playerChoice][0] = getValidInput(0,  playerWallets[playerChoice]);
			System.out.print("Which horse would you like to bet on?(enter 0 if you want to see the list of horses) ");
			int choice = getValidInput(0,  horsesInRace.length);
			if(choice == 0){
				diplayHorses(horsesInRace, horses);
				System.out.print("Which horse would you like to bet on? ");
				choice = getValidInput(1,  horsesInRace.length);
			}
			playerBets[playerChoice][1] = choice;
			System.out.println("Option(1.Bet, 2. Start Race):" );
			if(getValidInput(1,2) == 2) keepBetting = false;
		}
		return playerBets;

	}

	private static void displayPlayers(ArrayList<String> playerNames, int[] playerWallets) {
		System.out.println("");
		System.out.printf("%s" + "|" + "%-20s" + "|" + "%-10s|\n", "#", "Player Name", "Wallet");
		System.out.println("-|--------------------|----------|");
		for(int j =0; j<playerNames.size(); j++){
			System.out.printf("%d" + "|" + "%-20s|%10.2f" + "|\n", j+1, playerNames.get(j), (double)playerWallets[j]);
			System.out.println("-|--------------------|----------|");
		}
	}

	private static void diplayHorses(int[] horsesInRace, String[] horses) {
		// TODO Auto-generated method stub
		System.out.printf("%s" + "|" + "%-20s" + "|\n", "#", "Horse Name");
		System.out.println("-|--------------------|");
		for(int j =0; j<horsesInRace.length; j++){
			System.out.printf("%d" + "|" + "%-20s" + "|\n", j+1, horses[horsesInRace[j]]);
			System.out.println("-|--------------------|");
			
		}
	}

	public static int getValidInput(int min, int max){
		boolean isValid = false;
		int x = 0;
		while(!isValid){
			try{
				x = Integer.parseInt(keyboard.nextLine());
				if (x>=min && x<=max) 
					isValid = true;
				else System.out.print("Please enter a number between " + min + " and " + max + ": ");
			}catch(Exception ex){
				System.out.print("Please enter a number between " + min + " and " + max + ": ");
			}
		}
		
		return x;
	}

	private static int startRace(int[] horsesInRace, String[] horses) {
		// TODO Auto-generated method stub
		boolean raceOver = false;
		int[] spaces = new int[horsesInRace.length];
		int winningHorse = -1;
		for(int i = 0; i<horsesInRace.length; i++){
			spaces[i] = 1;
		}
		while(!raceOver){
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("--------------------|--------------------------------------------------------------------------------");
			for(int i = 0; i<horsesInRace.length;i++){
				if(spaces[i] >= 80){
					//winning horse only returns one horse passing the finish line
					winningHorse = horsesInRace[i];
					raceOver = true;
				}
				String format = "%" + spaces[i] + "d";
				System.out.printf("%20s" + "|" + format + "\n", horses[horsesInRace[i]], i+1);
				System.out.println("--------------------|--------------------------------------------------------------------------------");
				spaces[i] += (int)(Math.random()*5);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
		System.out.println(horses[winningHorse]);
		return winningHorse;
		
	}

	private static void updatePlayerData(ArrayList<String> playerNames, int[] playerWallets) {
		FileWriter fw;
		try {
			fw = new FileWriter(new File("input/player.dat"));
			fw.write(playerNames.size() + "\n");

			for(int i = 0; i < playerNames.size(); i++){
				fw.write(playerNames.get(i) + " " + playerWallets[i] + "\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean promptForGameOver() {
		System.out.print("Would you like to end the game, enter either yes or no: ");
		String response = keyboard.nextLine();
		return checkYesNo(keyboard, response);

	}

	private static boolean checkYesNo(Scanner keyboard, String message) {
		// TODO Auto-generated method stub
		while (!(message.toLowerCase().equals("yes") || message.toLowerCase().equals("no"))) {
			System.out.print("Please enter either yes or no:");
			message = keyboard.nextLine();
		}
		return message.toLowerCase().equals("yes");
	}

	private static void payOutBets(int[][] playerBets, int[] playerWallets, ArrayList<String> playerNames, int winningHorse) {
		// TODO Auto-generated method stub
		for(int i = 0; i<playerNames.size(); i++){
			if(playerBets[i][1] != -1){
				if(playerBets[i][1] == winningHorse){
					playerWallets[i] += playerBets[i][0];
				}else{
					playerWallets[i] -= playerBets[i][0];
				}
			}
		}
	}

	private static void closingMessage() {
		// TODO Auto-generated method stub
	
	}

	
	// Check if a horse is already in the race - uses a modified search method
	 
	public static boolean alreadyInRace(int horse, int[] horsesInRace) {

		for (int i = 0; i < horsesInRace.length; i++) {
			if (horsesInRace[i] == horse) {
				return true;
			}
		}

		return false;
	}
}
*/
