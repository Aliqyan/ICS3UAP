package com.bayviewglen.test;

public class mergeSort {

	public static void main(String[] args) {
		int[] arr1 = {1,9, 11, 12, 27, 108, 150};
		int[] arr2 = {2,8,10,13,19}; 
		int[] a = merge(arr1, arr2);
		display(a);
	}
	
	public static void display(int[] arr){
		for(int i =0; i < arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	public static int[] merge(int[] a1, int[] a2){
		int[] a = new int[a1.length + a2.length];
		int count1 = 0;
		int count2 = 0;
		int i = 0;
		while(count1 < a1.length && count2 < a2.length){
			if(a1[count1] < a2[count2]){
				a[i++] = a1[count1++];
			}else{
				a[i++] = a2[count2++];
			}
		}	
	
		while(count1 < a1.length){
			a[i++] = a1[count1++];
		}
		while(count1 < a2.length){
			a[i++] = a2[count2++];
		}
		return a;
	}
	
	

}
