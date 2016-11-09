package com.bayviewglen.daysix;

public class HomeworkFive {

	public static void main(String[] args) {
		int won = 110;
		int loss = 44;
		int total = won + loss;
		double percentage = ((int)((double)won/total * 100000))/1000.00;
		System.out.println("The win/loss percentage is : " + percentage + "%");
	}

}
