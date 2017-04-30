package com.bayviewglen.trialone;

import java.io.File;
import java.util.Scanner;

public class tidy {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("input/input.txt"));
			int times = Integer.parseInt(scanner.nextLine());
			for(int i = 1; i<= times; i++){
				String line = scanner.nextLine();
				System.out.println("Case #" + i + ": "  + tidyNumber(line));
			}
		}catch(Exception e){
			//test
		}
		
	}
	public static String tidyNumber(String x){
		for(int i = 0; i < x.length()-1;i++){
			if(("" + x.charAt(i)).compareTo(("" + x.charAt(i+1))) > 0){
				return tidyNumber("" + (Integer.parseInt(x)-1));
			}
		}
		return x;
	}

}
