package com.vishal.sorting;

public class MergeSort {

	static int a[] = { 12, 3, 5, 18, 25 };

	public static void main(String[] args) {
		sort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static void sort(int[] a, int beg, int end) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			sort(a, beg, mid);
			sort(a, mid + 1, end);
			merge(a, beg, mid, end);
		}
	}

	private static void merge(int[] a, int beg, int mid, int end) {

		int i = beg, j = mid + 1, k = beg;

		int temp[] = new int[a.length];
		
		for (int l = beg; l <= end; l++) {
			temp[l] = a[l];
		}

		while (i <= mid && j <= end) {
			if (temp[i] <= temp[j]) {
				a[k] = temp[i];
				i++;
				k++;
			} else {
				a[k] = temp[j];
				j++;
				k++;
			}
		}

		while (i <= mid) {
			a[k] = temp[i];
			i++;
			k++;
		}

		while (j <= end) {
			a[k] = a[j];
			j++;
			k++;
		}
	}

}
