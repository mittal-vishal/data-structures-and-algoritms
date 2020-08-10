package com.vishal.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int a[] = { 12, 3, 5, 18, 7 };
		sort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static void sort(int a[], int beg, int end) {
		if (beg < end) {
			int p = partition(a, beg, end);
			sort(a, beg, p - 1);
			sort(a, p + 1, end);
		}
	}

	private static int partition(int[] a, int beg, int end) {
		int pivot = end;
		int i = beg - 1;
		int temp = 0;
		for (int j = beg; j <= end; j++) {
			if (a[j] < a[pivot]) {
				i++;
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		temp = a[i + 1];
		a[i + 1] = a[pivot];
		a[pivot] = temp;
		return i + 1;
	}

}
