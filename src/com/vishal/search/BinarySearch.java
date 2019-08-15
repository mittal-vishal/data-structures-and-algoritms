package com.vishal.search;

public class BinarySearch {

	public static void main(String[] args) {
		int a[] = { 1, 3, 7, 11, 15, 21, 35, 44, 56 };
		System.out.println(find(a, 3));
	}

	private static int find(int[] a, int i) {
		return find(a, 0, a.length - 1, i);
	}

	private static int find(int[] a, int start, int end, int item) {
		int mid = (start + end) / 2;
		if (start > end) {
			return -1;
		}
		if (item == a[mid]) {
			return mid + 1;
		} else if (item < a[mid]) {
			return find(a, 0, mid - 1, item);
		} else {
			return find(a, mid + 1, end, item);
		}
	}

}
