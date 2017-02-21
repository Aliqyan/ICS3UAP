package com.bayviewglen.contestquestions;

public class ArrialTime {

	public static void main(String[] args) {
		String input = "5:00";
		int hour = Integer.parseInt(input.split(":")[0]);
		int min = Integer.parseInt(input.split(":")[1]);
		int minTotal = hour * 60 + min;
		System.out.println(minTotal);

		if((minTotal <= 5 *60 || minTotal >= 10*60) && (minTotal <= 13 *60 || minTotal >= 19*60)){
			System.out.printf((hour + 2)%24 + ":" + "%02d", min);
		}else if((minTotal <= 8 *60 && minTotal > 7*60) || (minTotal <= 17 *60 && minTotal >= 15*60)){
			System.out.printf(hour + 4 + ":" + "%02d", min);
		}else if(minTotal >= 13*60){
			 minTotal = 10 * 60 + 120 - (10*60 - minTotal)/2;
			System.out.printf(minTotal/60 + ":" + "%02d", minTotal % 60);
		}else{
			minTotal = 10 * 60 + 120 - (10*60 - minTotal)/2;
			System.out.printf(minTotal/60 + ":" + "%02d", minTotal % 60);
		}
			
		
	}

}
