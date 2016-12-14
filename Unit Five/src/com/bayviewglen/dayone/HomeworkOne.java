package com.bayviewglen.dayone;

import java.text.DecimalFormat;

public class HomeworkOne {

	public static void main(String[] args) {
		cubeRoots();
	}
	public static void cubeRoots(){
		for(int i = 10; i <= 50;i++){
			double x = Math.pow(i, 1.0/3);
			System.out.printf("%4d %10.4f \n", i, x);
		}
	}

}
