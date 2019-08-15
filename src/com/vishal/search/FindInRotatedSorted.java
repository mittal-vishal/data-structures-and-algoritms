package com.vishal.search;

public class FindInRotatedSorted {

	public static void main(String[] args) {
		int a[] = { 10, 20, 30, 40, 50, 60, 1 };
		System.out.println(find(a, 34));
	}

	private static int find(int[] a, int item) {
		int index = findRotatedIndex(a, 0, a.length - 1);
		int result = 0;
		if (index != -1) {
			result = find(a, 0, index - 1, item) == -1 ? find(a, index, a.length - 1, item)
					: find(a, 0, index - 1, item);
		} else {
			result = find(a, 0, a.length - 1, item);
		}
		return result;
	}

	private static int findRotatedIndex(int[] a, int beg, int end) {
		int mid = (beg + end) / 2;
		if (beg > end) {
			return -1;
		}
		if (a[mid] > a[0] && a[mid] > a[end]) {
			return findRotatedIndex(a, mid + 1, end);
		} else if (a[mid] < a[0] && a[mid] < a[end]) {
			return findRotatedIndex(a, beg, mid - 1);
		} else {
			return mid;
		}
	}

	private static int find(int[] a, int start, int end, int item) {
		int mid = (start + end) / 2;
		if (start > end) {
			return -1;
		}
		if (item == a[mid]) {
			return mid;
		} else if (item < a[mid]) {
			return find(a, start, mid - 1, item);
		} else {
			return find(a, mid + 1, end, item);
		}
	}

}
