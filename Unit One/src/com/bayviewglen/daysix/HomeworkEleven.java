package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkEleven {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("The mass is : ");
		int m = keyboard.nextInt();
		System.out.println("The velocity is : ");
		int v = keyboard.nextInt();
		double kineticEnergy = 0.5*(m)*Math.pow(v, 2);
		System.out.println("The kinetic energy is : " + kineticEnergy);
		keyboard.close();
	}

}
