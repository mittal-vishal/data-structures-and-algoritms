package com.vishal.arrays;

public class MaxIndexDifference {

	public static void main(String[] args) {
		int a[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		System.out.println(getMaxIndex(a, a.length));
	}

	private static int getMaxIndex(int a[], int n) {
		int min = -1;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (a[j] >= a[i] && j - i > min) {
					min = j - i;
				}
			}
		}
		return min;
	}

}
