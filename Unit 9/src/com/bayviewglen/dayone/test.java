package com.bayviewglen.dayone;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(1000));
	}
	public static int  fib(int n){
		if(n==2 || n==1){
			return 1;
		}
		else{
			return fib(n-1) + (n-2);
		}
	}

}
