package com.vishal.arrays;

public class ReverseArray {

	public static int[] reverse(int[] a) {
		int temp = 0;
		int arrayLength = a.length;
		for (int i = 0; i < a.length / 2; i++) {
			temp = a[i];
			a[i] = a[arrayLength - 1];
			a[arrayLength - 1] = temp;
			arrayLength--;
		}
		return a;
	}

}
