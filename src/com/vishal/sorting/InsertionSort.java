package com.vishal.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int a[] = { 12, 3, 5, 18, 25 };
		a = sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static int[] sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			int item = a[i];
			while (j >= 0 && item < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = item;
		}
		return a;
	}

}
