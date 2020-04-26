package com.vishal.dynamicprogramming;

public class LIS {

	public static void main(String[] args) {
		int[] array = { 3, 4, 2, 8, 10 };
		System.out.println(find(array, array.length, Integer.MAX_VALUE));
	}

	private static int find(int[] array, int n, int next) {
		if(n == 0) {
			return 0;
		}
		if(array[n-1] < next) {
			return Math.max(1 + find(array, n-1, array[n-1]), find(array, n-1, next));
		}else {
			return find(array, n-1, next);
		}
	}

}
