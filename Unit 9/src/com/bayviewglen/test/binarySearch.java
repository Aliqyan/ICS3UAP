package com.bayviewglen.test;

public class binarySearch {
	static int iteration = 0;
	public static void main(String[] args) {
		int arr[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13};
		int key = 23;
		System.out.println(bSearch(arr, 0,arr.length-1, key));
	}
	public static int bSearch(int[] arr, int low, int high, int key){
		iteration ++;
		System.out.println("This is iteration number " + iteration);
		if(low>high) return -1;
		int mid = (low + high)/2;
		if(arr[mid] == key) return mid;
		else if(arr[mid] < key)return bSearch(arr, mid+1, high, key);
		else return bSearch(arr, low, mid-1, key);
	}
	

}
