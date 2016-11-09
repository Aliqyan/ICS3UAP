package com.bayviewglen.contestquestions;

import java.util.ArrayList;
import java.util.Arrays;

public class WordSearch {

	public static void main(String[] args) {
		int r = 17;
		int c = 17;
		int n = 37;
		ArrayList<String> crossword = new ArrayList<>(Arrays.asList("KLIMTSEINWORBCHOC", "CGOLYNASEMISWEETT",
				"EHNCSDENETEEWSNUO", "RCIIOENIIGFILLING", "SIOPKCLADNABFTESE", "KFRNSAOFCEIOOMCTV", "NRHEFDBAFTRSOEHEI",
				"ICATAERTTUIGDDOGT", "RORDSNCECCRONSCNC", "DOWEFTRTEUTTUIOII", "GKHTASPCIRPOHFLDD", "NIIEWMRUEOICOTADD",
				"IETESEPSRCNNAHTUA", "CSESAESIIYDEBKIPO", "ITIMBERLEUSAROEAM", "AWFUDGECEARCAYRSO",
				"SUGARDTESSUOMRSEE"));
		ArrayList<String> newCrossword = new ArrayList<>();
		newCrossword = (ArrayList<String>)crossword.clone();
			
		ArrayList<String> word = new ArrayList<>(Arrays.asList("ADDICTIVE", "BAKING", "BARS", "BITTERSWEET", "BROWNIES",
				"CAKES", "CANDY", "CHIPS", "CHOCOLATIERS", "COCOA", "CONFECTIONERY", "COOKIES", "CREAM PIE", "CUPCAKE",
				"DARK", "DECADENT", "DELICIOUS", "DESSERT", "DRINKS", "FILLING", "FONDUE", "FOOD", "FUDGE", "ICE CREAM",
				"ICING", "INGREDIENT", "MILK", "MOUSSE", "PUDDING", "SEMISWEET", "SUGAR", "SWISS", "SYRUP", "TREAT",
				"TRUFFLES", "UNSWEETENED", "WHITE"));
		String spaces = "";
		//horiz
		for(int w = 0; w < n; w++){
			for(int i = 0; i < r ;i++){
				for(int j = 0; j < c - word.get(w).length() +1; j++){
					spaces = "";
					if(word.get(w).equals(crossword.get(i).substring(j, j + word.get(w).length()))){
						System.out.println(word.get(w) + " found at array: " + i + ", and index: " + j + " to " + (j + word.get(w).length()));
						for(int k = 0; k < word.get(w).length(); k++)
							spaces += " ";
						newCrossword.set(i, crossword.get(i).substring(0,j) + spaces + crossword.get(i).substring(j + word.get(w).length()));
					}
				}
			}
		}
		//horiz backwards
		for(int w = 0; w < n; w++){
			for(int i = 0; i < r ;i++){
				for(int j = c; j > word.get(w).length() -1; j--){
					spaces = "";
					int x = 0;
					for(int m = 0; m < word.get(w).length() ; m ++){
						if(word.get(w).charAt(m) == crossword.get(i).charAt(j-m-1)){
							x += 1;		
						}
					}
					if(x >= word.get(w).length()){
						System.out.println(word.get(w) + " found at array: " + i + ", and index: " + (j - word.get(w).length()) + " to " + j  );
						for(int k = 0; k < word.get(w).length(); k++)
							spaces += " ";
						newCrossword.set(i, newCrossword.get(i).substring(0,j - word.get(w).length()) + spaces + newCrossword.get(i).substring(j));
					}
				}
			}
		}
		System.out.println("");
		
		//vert
		for(int w = 0; w < n; w++){
			for(int j = 0; j < c ;j++){
				for(int i = 0; i < r - word.get(w).length(); i++){
					int x = 0;
					for(int m = 0; m < word.get(w).length() ; m ++){
						if(word.get(w).charAt(m) == crossword.get(i+m).charAt(j)){
							x += 1;		
						}
					}
					if(x >= word.get(w).length()){
						System.out.println(word.get(w) + " found at index: " + j + ", and arrays: " + i + " to " +(i + word.get(w).length()) );
						for(int k = i; k < i + word.get(w).length(); k++)
							newCrossword.set(k, newCrossword.get(k).substring(0,j) + " " + newCrossword.get(k).substring(j+1));
						
					}
				}
			}
		}
		System.out.println(" ");
		for(int w = 0; w < n; w++){
			for(int j = 0; j < c ;j++){
				for(int i = r-1; i > word.get(w).length(); i--){
					int x = 0;
					for(int m = 0; m < word.get(w).length() ; m ++){
						if(word.get(w).charAt(m) == crossword.get(i-m).charAt(j)){
							x += 1;		
						}
					}
					if(x >= word.get(w).length()){
						System.out.println(word.get(w) + " found at index: " + j + ", and arrays: " + (i - word.get(w).length() +1) + " to " + i );
						for(int k = i - word.get(w).length() + 1; k < i; k++)
							newCrossword.set(k, newCrossword.get(k).substring(0,j) + " " + newCrossword.get(k).substring(j+1));
						
						
					}
				}
			}
		}
		
		
			
		System.out.println("");
		for(int i =0; i < r;i++){
			System.out.print(crossword.get(i) + "\t\t\t");
			System.out.println(newCrossword.get(i));
		}
		
	}
	

}
