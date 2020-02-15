package com.vishal.dynamicprogramming;

public class OptimalStrategyGame {

	public static void main(String[] args) {
		int[] array = { 20, 5, 4, 6 };
		System.out.println(find(array, 0, array.length - 1));
	}

	private static int find(int[] array, int start, int end) {
		int sum = 0;
		for(int i : array) {
			sum = sum + i;
		}
		return find(array, sum, start, end);
	}

	private static int find(int[] array, int sum, int i, int j) {
		if (j == i + 1) {
			return Math.max(array[i], array[j]);
		} else {
			return Math.max((sum - find(array, sum - array[i], i + 1, j)), (sum - find(array, sum - array[j], i, j - 1)));
		}
	}

}
