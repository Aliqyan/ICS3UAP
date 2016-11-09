package com.bayviewglen.daytwo;

public class FramingSquares {

	public static void main(String[] args) {
		int m = 2;
		int n = 3;
		int p = 1;
		int q = 1;
		
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < 2 * q + 2 * p + n; j++){
				System.out.print("#");
			}
			System.out.println("");
		}
		
		for(int i = 0; i < p; i++){
			for(int j = 0; j < q; j++){
				System.out.print("#");
			}
			for(int j = 0; j < 2*p + n; j++){
				System.out.print("+");
			}
			for(int j = 0; j < q; j++){
				System.out.print("#");
			}
			System.out.println("");
			
		}
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < q; j++){
				System.out.print("#");
			}
			for(int j = 0; j < p; j++){
				System.out.print("+");
			}
			for(int j = 0; j < n; j++){
				System.out.print(".");
			}			
			for(int j = 0; j < p; j++){
				System.out.print("+");
			}
			for(int j = 0; j < q; j++){
				System.out.print("#");
			}
			System.out.println("");
		}
		
		for(int i = 0; i < p; i++){
			for(int j = 0; j < q; j++){
				System.out.print("#");
			}
			for(int j = 0; j < 2*p + n; j++){
				System.out.print("+");
			}
			for(int j = 0; j < q; j++){
				System.out.print("#");
			}
			System.out.println("");
			
		}
		
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < 2 * q + 2 * p + n; j++){
				System.out.print("#");
			}
			System.out.println("");
		}
	}

}
