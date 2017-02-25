package com.bayviewglen.contestquestions;

import java.util.Scanner;

public class QuestionThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String dot1 = keyboard.nextLine();
		int x1 = Integer.parseInt(dot1.split(" ")[0]);
		int y1 = Integer.parseInt(dot1.split(" ")[1]);
		String dot2 = keyboard.nextLine();
		int x2 = Integer.parseInt(dot2.split(" ")[0]);
		int y2 = Integer.parseInt(dot2.split(" ")[1]);
		int t = Integer.parseInt(keyboard.nextLine());
		
		int answer = Math.abs(x2 - x1) + Math.abs(y2 - y1);
		int z = t - answer;
		if (z >= 0) {
			if ((t - answer) % 2 == 0) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		} else {
			System.out.println("N");
		}
	}

}
