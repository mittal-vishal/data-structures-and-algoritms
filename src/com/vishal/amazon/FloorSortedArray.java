package com.vishal.amazon;

public class FloorSortedArray {
	
	static int floor = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int a[] = { 1, 2, 8, 10, 11, 12, 17 };
		System.out.println(find(a, 0, a.length - 1, 17));
	}

	private static int find(int[] a, int beg, int end, int item) {
		int mid = (beg + end) / 2;
		
		if (beg > end) {
			return floor;
		}

		if (item == a[mid]) {
			return mid;
		} else if (item < a[mid] && mid != a.length - 1) {
			if(mid != 0) {
				floor = mid;
				return find(a, beg, mid - 1, item);
			}else {
				return -1;
			}
		} else if (item > a[mid]) {
			floor = mid;
			return find(a, mid + 1, end, item);
		} else {
			return floor;
		}
	}

}
