package com.vishal.search;

public class CountOccuranceSortedNumbers {

	public static void main(String[] args) {
		int a[] = { 1, 3, 3, 3, 3, 12, 21, 21, 44, 56 };
		System.out.println(find(a, 3));
	}

	private static int find(int[] a, int i) {
		int lowerBound = find(a, 0, a.length - 1, i, true);
		int upperBound = find(a, 0, a.length - 1, i, false);
		if(lowerBound == -1 || upperBound == -1) {
			return 0;
		}else {
			return upperBound - lowerBound + 1;
		}
	}

	private static int find(int[] a, int start, int end, int item, boolean isLowerBound) {
		int mid = (start + end) / 2;
		if (start > end) {
			return -1;
		}
		if(isLowerBound) {
			if (item == a[mid] && (mid == 0 ||item != a[mid - 1])) {
				return mid;
			} else if (item <= a[mid]) {
				return find(a, start, mid - 1, item, true);
			} else {
				return find(a, mid + 1, end, item, true);
			}
		}else {
			if (item == a[mid] && (mid == 0 ||item != a[mid + 1])) {
				return mid;
			} else if (item < a[mid]) {
				return find(a, start, mid - 1, item, false);
			} else {
				return find(a, mid + 1, end, item, false);
			}
		}
	}

}
