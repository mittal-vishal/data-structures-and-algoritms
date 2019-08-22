package com.vishal.search;

public class PeakElement {

	public static void main(String[] args) {
		int a[] = { 10, 20, 3, 5, 23, 50, 67 };
		System.out.println(find(a));
	}

	private static int find(int[] a) {
		return find(a, 0, a.length - 1);
	}

	private static int find(int[] a, int beg, int end) {
		int mid = (beg + end) / 2;
		if ((0 == beg && a[mid] > a[mid + 1]) || (mid == a.length - 1 && a[mid] > a[mid - 1])
				|| (end >= beg && a[mid] > a[mid - 1] && a[mid] > a[mid + 1])) {
			return mid;
		} else if (a[mid] < a[mid - 1]) {
			return find(a, beg, mid - 1);
		} else if(a[mid] < a[mid + 1]){
			return find(a, mid + 1, end);
		} else {
			return -1;
		}
	}

}
