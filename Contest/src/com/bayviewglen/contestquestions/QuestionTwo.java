package com.bayviewglen.contestquestions;

import java.util.Scanner;

public class QuestionTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		int k = keyboard.nextInt();
		int answer = 0;
		for(int i =0; i <= k;i++){
			answer += n * Math.pow(10, i);
		}
		System.out.println(answer);
	}

}
