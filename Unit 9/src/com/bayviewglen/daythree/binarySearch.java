package com.bayviewglen.daythree;

public class binarySearch {

	public static void main(String[] args) {
		
	}
	public static int binarySearch(int[] arr, int search, int low, int high){
		int mid = (low+ high)/2;
		if(low > high)
			return -1;
		else if(arr[mid] == search)
			return mid;
		else if(search < arr[mid])
			return binarySearch(arr, search, low, mid-1);
		else
			return binarySearch(arr, search, mid+1, high);
		
	}

}
