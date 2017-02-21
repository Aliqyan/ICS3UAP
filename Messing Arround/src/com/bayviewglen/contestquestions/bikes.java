package com.bayviewglen.contestquestions;

import java.util.Arrays;

public class bikes {

	public static void main(String[] args) {
		int choice = 2;
		int num = 5;
		int[] arr1 = {202, 177, 189, 589, 102}; 
		int[] arr2 = {17, 78, 1, 496, 540}; 
		int answer = 0;
		if(choice == 1){
			for(int i =0; i < num; i++){
				if(arr1[i] > arr2[i]) answer +=arr1[i];
				else answer +=arr2[i];
			}
		}else if(choice == 2){
			int[] arr = new int[2*num];
			int j = 0;
			for(int i = 0; i<num; i++){
				arr[j++] = arr1[i];
				arr[j++] = arr2[i];				
			}
			Arrays.sort(arr);
			for(int i = arr.length/2; i < arr.length; i++){
				answer += arr[i];
			}
			
		}
		
		System.out.println(answer);
	}

}
