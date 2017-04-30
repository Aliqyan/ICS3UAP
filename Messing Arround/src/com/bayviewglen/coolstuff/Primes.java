package com.bayviewglen.coolstuff;

import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for(long i = 3; i<1000000000;i++){
			System.out.println(i);
			boolean isPrime = true;
			for(int j = 0; j < primes.size(); j++){
				if(i % primes.get(j) == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime) primes.add((int)i);
		}
		System.out.println(primes);
	}

}
