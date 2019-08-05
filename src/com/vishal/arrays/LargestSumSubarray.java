package com.vishal.arrays;

public class LargestSumSubarray {

	public static void main(String[] args) {
		int a[] = { -3, 4, -1, -6, 1, 5 };
		System.out.println(findLargestSum(a));
	}

	private static int findLargestSum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				sum = sum + a[i];
			} else if (a[i] <= 0 && sum + a[i] > 0) {
				sum = sum + a[i];
			} else {
				sum = 0;
			}
		}
		return sum;
	}

}
