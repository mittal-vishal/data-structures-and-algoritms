package com.vishal.arrays;

public class RotateClockwise {

	public static int[] rotate(int a[], int r) {
		r = r % a.length;
		int b[] = new int[a.length];
		int k = 0;
		for (int i = r; i < a.length; i++) {
			b[k++] = a[i];
		}
		for (int i = 0; i < r; i++) {
			b[k++] = a[i];
		}
		return b;
	}

}
