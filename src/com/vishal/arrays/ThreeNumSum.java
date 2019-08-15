package com.vishal.arrays;

public class ThreeNumSum {

	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 8, 9, 22, 40 };
		System.out.println(findTriplet(a, 32));
	}

	private static String findTriplet(int[] a, int item) {
		for (int i = 0; i < a.length-2; i++) {
			if (find(a, i+1, a.length - 1, item - a[i]).equals("found")) {
				return "found";
			}
		}
		return "not found";
	}

	private static String find(int[] a, int left, int right, int item) {
		while (left != right) {
			if (a[left] + a[right] == item) {
				return "found";
			} else if (a[left] + a[right] > item) {
				right--;
			} else {
				left++;
			}
		}
		return "not found";
	}

}
