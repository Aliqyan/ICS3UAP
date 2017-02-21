package com.bayviewglen.test;

public class PracticeProblems {

	public static void main(String[] args) {
		int manyItems = 5;
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		/*System.out.println(manyItems);
		display(arr);
		manyItems = remove(arr, manyItems, 3);
		display(arr);
		System.out.println(manyItems);
		
		
		System.out.println(manyItems);
		display(arr);
		manyItems = add(arr, manyItems, 3, 8);
		display(arr);
		System.out.println(manyItems);
		
		
		System.out.println(manyItems);
		display(arr);
		manyItems = removeOrdered(arr, manyItems, 3);
		display(arr);
		System.out.println(manyItems);
		*/
		
		System.out.println(manyItems);
		display(arr);
		manyItems = addOrdered(arr, manyItems, 3, 0);
		display(arr);
		System.out.println(manyItems);
	}
	
	public static void display(int[] arr){
		for(int i =0; i < arr.length;i++){
			System.out.print(arr[i]);
		}
		System.out.println("");
	}
	
	public static int remove(int[] arr, int manyItems, int index){
		if(index < 0 || index >= manyItems) return -1;
		arr[index] = arr[--manyItems];
		return manyItems;
	}
		
	public static int add(int[] arr, int manyItems, int index, int value){
		if(index < 0 || index >= manyItems) return-1;
		arr[manyItems++] = arr[index];
		arr[index] = value;
		return manyItems;
	}
	
	public static int removeOrdered(int[] arr, int manyItems, int index){
		if(index < 0 || index >= manyItems) return-1;
		for(int i = index; i < manyItems; i++){
			arr[i] = arr[i+1];
		}
		return --manyItems;
	}
	
	public static int addOrdered(int[] arr, int manyItems, int index, int value){
		for(int i = manyItems; i >= index;i--){
			arr[i+1] = arr[i];
		}
		arr[index] = value;
		return ++manyItems;
	}
}
