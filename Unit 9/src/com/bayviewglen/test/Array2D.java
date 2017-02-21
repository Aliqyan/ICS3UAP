package com.bayviewglen.test;

import java.util.Arrays;

public class Array2D {

	public static void main(String[] args) {
		for(int i =0; i< 1000; i++){
			System.out.println((int)(Math.random()*2));
		}
	String[][] arr = new String[5][5];
			// {{2,34,3},{4,5}, {6}, {8,9,111,43,9,1}};
	
	for(int i = 0;i <arr.length; i++){
			//Arrays.sort(arr[i]);
			for(int j = 0; j<arr[i].length; j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		

	}

}
