package com.vishal.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int a[] = { 12, 3, 5, 18, 25 };
		a = sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static int[] sort(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}

}
