package com.bayviewglen.coolstuff;

import java.util.Scanner;

public class MorseCode {
	static String[] morseCode = {".-", " -... ", "-.-.", "-..",  ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
	static String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X", "Y", "Z" };
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); 
		System.out.print("Would you like to (1) turn a phrase to morse code, or (2) decipher a morse code phrase: ");
		String choice = keyboard.nextLine();
		while (!choice.equals("1") && !choice.equals("2")){
			System.out.println("Please enter 1 or 2: ");
			choice = keyboard.nextLine();
		}
		System.out.print("The text is: ");
		String inputPhrase = keyboard.nextLine().toUpperCase();
		if(choice.equals("1")){
			toMorse(inputPhrase);
		}else if(choice.equals("2")){
			fromMorse(inputPhrase);
		}
	
		
		
	
		
	}
	public static void toMorse(String inputPhrase){
		String codedPhrase = "";
		for(int i = 0; i < inputPhrase.length();i++){
			int characterIndex = (int)inputPhrase.charAt(i) - 65;
			if(inputPhrase.charAt(i) == ' '){
				codedPhrase += "/ ";
			}else{
				codedPhrase += morseCode[characterIndex] + " ";
			}
		} 
		System.out.println(codedPhrase);
	}
	
	public static void fromMorse(String inputPhrase){
		String decipheredPhrase = "";
		int space = 0;
		String currentWord = "";
		for (int i = 0; i < inputPhrase.length(); i++) {
			if (inputPhrase.charAt(i) == ' ' || i == inputPhrase.length()-1) {
				currentWord = inputPhrase.split(" ")[space];
				space++;
				for (int j = 0; j < morseCode.length; j++) {
					if (morseCode[j].equals(currentWord)){
						decipheredPhrase += letters[j];
					}
				}
			}else if(inputPhrase.charAt(i) == '/'){
				decipheredPhrase += " ";
			}
			

		}
		System.out.println(decipheredPhrase);
	}
	
}

