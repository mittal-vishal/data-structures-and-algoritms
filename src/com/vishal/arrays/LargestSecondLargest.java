package com.vishal.arrays;

public class LargestSecondLargest {

	public static void main(String[] args) {
		int a[] = { 2, 1, 2 };
		find(a);
	}

	private static void find(int a[]) {
		int max = 0;
		int secondMax = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				secondMax = max;
				max = a[i];
			} else if (a[i] > secondMax && a[i] < max) {
				secondMax = a[i];
			}
		}
		System.out.println(max);
		System.out.println(secondMax);
	}

}
