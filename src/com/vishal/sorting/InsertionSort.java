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
			int j = i;
			int element = a[i];
			while (j >= 1 && a[j] < a[j - 1]) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = element;
		}
		return a;
	}

}
