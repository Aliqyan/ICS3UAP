package com.tapiadevelopmentinc.hashmaps;

import java.util.HashMap;
import java.util.Scanner;

// Monday, 20th March 2017
//attempt #1 for HashMaps
public class Hashmap {

	public static void main(String[] args) {
		HashMap<Integer,String> a = new HashMap<Integer, String>();
		String[] value = {"a", "b", "c", "d", " aliqyan", "E", "f", "g", "h", "i"}; 
		for(int i = 0; i< 10; i++){
			a.put(i+1, value[i]);
		}
		Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		System.out.println(a.get(choice));
	}

}
