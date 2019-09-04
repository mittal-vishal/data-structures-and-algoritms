package com.vishal.arrays;

import java.util.Arrays;

public class ThreeNumSum {

	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 40, 8, 20, 9 };
		Arrays.sort(a);
		System.out.println(findTriplet(a, 39));
	}

	private static boolean findTriplet(int[] a, int item) {
		Arrays.sort(a);
		int left = -1, right = -1;
		for (int i = 0; i < a.length - 2; i++) {
			left = i + 1;
			right = a.length - 1;
			while (left < right) {
				if (a[left] + a[right] + a[i] == item) {
					return true;
				} else if (a[left] + a[right] > item) {
					right--;
				} else {
					left++;
				}
			}
		}
		return false;
	}

}
