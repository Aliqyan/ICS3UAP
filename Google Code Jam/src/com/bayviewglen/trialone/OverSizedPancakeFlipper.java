package com.bayviewglen.trialone;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OverSizedPancakeFlipper {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("input/input.txt"));
			int times = Integer.parseInt(scanner.nextLine());

			for (int i = 1; i <= times; i++) {
				String result = "Impossible";
				String temp = scanner.nextLine();
				String curr = temp.split(" ")[0];
				String flipable = "";
				int k = Integer.parseInt(temp.split(" ")[1]);

				if (temp.indexOf("-") == -1)
					result = "0";
				else {
					boolean[] x = new boolean[temp.length()];
					for (int j = 0; j < temp.length(); j++) {
						if(temp.charAt(j) == '+') x[j] = (true);
						else x[j] = false;
					}
					for (int j = 0; j < k; j++) {
						flipable += "-";
					}
					if(temp.indexOf(flipable) != -1){
						int y = temp.indexOf(flipable);
						x[y] = !x[y];
						x[y+1] = !x[y+1];
						x[y+2] = !x[y+2];
					}
				}

				System.out.println("Case #" + i + ": " + result);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
