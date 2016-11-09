package com.bayviewglen.dayfive;

public class HomeworkSix {

	public static void main(String[] args) {
		double x = 5.5, y = 3.0, z = -2.0;
		int i = 5, j = 4, k = 3;
		
		x += y;
		y += y;
		z -= x - y;
		i *= j + k;	// the same as i = (j+k)*i
		j /= k; // j = j/k ** is an int
		System.out.println(x + ", " + y + ", " + z + ", " + i + ", " + j + ", " + k );
	}

}
