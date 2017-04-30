package com.bayviewglen.coolstuff;

public class PasswordGenerator {

	public static void main(String[] args) {
		int characters = 6;
		for(int i = 0; i < characters; i++){
			System.out.print((int)(Math.random()*10));
		}
		
	}

}
