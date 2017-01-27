package com.bayviewglen.dayfive;

public class DiverseArray {
	static int[] arr = {1,2,3,4,5,6,9};
	static int[][] arr2D = {
			{1,2,3,4,8},
			{1,3},
			{10,23,-1,23,56}
			};
	public static void main(String[] args) {
		int sum = arraySum(arr);
		System.out.println("The sum is: " + sum);
		int[] rowSum = rowSums(arr2D); 
		display(rowSum);
		
		
		
		
	}
	
	private static int[] rowSums(int[][] x) {
		int[] sums = new int[x.length]; 
		for(int i = 0; i < x.length;i++){
			sums[i] = arraySum(x[i]);
		}
		return sums;
	}

	public static int arraySum(int[] nums){
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
		}
		return sum;
	}
	
	private static void display(int[] a) {
		System.out.println("The partially filled array with elements: ");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
	}
	
	
	
	
}
