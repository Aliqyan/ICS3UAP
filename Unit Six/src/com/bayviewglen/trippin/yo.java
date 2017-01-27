package com.bayviewglen.trippin;

public class yo {

	public static void main(String[] args) {
		System.out.println(fizzBuzz(1,6));
	}
	public static String[] fizzBuzz(int start, int end) {
		  String[] arr = new String[end-start];
		  for(int i = start; i < end; i++){
		    if(i %3 ==0 && i%5 ==0) arr[i] = "FizzBuzz";
		    else if(i %3 ==0) arr[i] = "Fizz";
		    else if(i %5 ==0) arr[i] = "Buzz";
		    else arr[i] = String.valueOf(i);
		  }
		  return arr;
		}

}
