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
		int pivot = a[beg];
		int i = beg + 1;
		int j = end;
		while(i < j){
			while(i <= end && a[i] <= pivot){
				i++;
			}
			while(j >= 0 && a[j] > pivot){
				j--;
			}
			if(i < j){
				swap(a, i, j);
			}
		}
		swap(a, beg, j);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
