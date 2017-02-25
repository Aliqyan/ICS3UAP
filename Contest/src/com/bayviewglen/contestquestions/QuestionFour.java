package com.bayviewglen.contestquestions;

import java.text.DecimalFormat;
import java.util.Scanner;

public class QuestionFour {

	public static void main(String[] args) {
		
		//String[] possibilities = {"34", "111", "123", "135", "147", "159", "222", "234", "246", "258", "333", "345", "357", "369", "444", "456", "468", "555", "567", "579", "666", "678", "777", "789", "888", "999", "1111"}; 
		int[] poss = {34, 111, 123, 135, 147, 159, 210, 222, 234, 246, 258, 321, 333, 345, 357, 420, 432, 444, 456, 531, 543, 555, 630, 642, 654, 741, 753, 840, 852, 951, 1111}; 
		
		DecimalFormat formatter = new DecimalFormat("00");

		Scanner keyboard = new Scanner(System.in);
		int minTotal = keyboard.nextInt();
		int min = minTotal%60;
		int hour = (minTotal/60)%12;
		int multiplier = (minTotal/60)/12;
		String num = hour + "" + formatter.format(min);
		int x = Integer.parseInt(num);
		int count = 0;
		while (x >= poss[count]){
			count++;
		} 
			System.out.println(count + multiplier*(poss.length));
		
	}

}
