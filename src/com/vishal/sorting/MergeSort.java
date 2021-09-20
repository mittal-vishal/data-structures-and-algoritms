package com.vishal.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = { 12, 3, 5, 18, 25 };
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

		int i = beg, j = mid + 1;

		int temp[] = new int[end - beg + 1];

		int idx = 0;

		while (i <= mid && j <= end) {
			if (a[i] <= a[j]) {
				temp[idx++] = a[i++];
			} else {
				temp[idx++] = a[j++];
			}
		}

		while (i <= mid) {
			temp[idx++] = a[i++];
		}

		while (j <= end) {
			temp[idx++] = a[j++];
		}

		for(int k = beg; k <= end; k++){
			a[k] = temp[k-beg];
		}
	}

}
