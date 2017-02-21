package com.bayviewglen.contestquestions;

import java.util.Scanner;

public class palindrome {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = 1;
		int temp = 0;
		String x = sc.nextLine();
		
		for (int i = 1; i < x.length() - 1; i++) {
			temp = 1;
			int j = 1;
			while (i - j >= 0 && i + j <= x.length() -1 && x.charAt(i - j) == x.charAt(i + j)) {
				j++;
				temp += 2;
			}
			if(x.charAt(i) == x.charAt(i+1)){
				temp = 2;
				while (i - j >= 0 && i + j+1<= x.length() -1 && x.charAt((int)(i - j)) == x.charAt((int)(i + 1 + j))) {
					j++;
					temp += 2;
					
				}
			}
			if (temp > count)
				count = temp;
		}
		
		System.out.println(count);

	}
}
