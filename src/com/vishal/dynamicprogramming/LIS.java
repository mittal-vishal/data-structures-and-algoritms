package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
		int[] array = { 3, 4, 2, 8, 10 };
		System.out.println(find(array, array.length));
	}

	private static int find(int[] array, int n) {
		int[] lis = new int[n];
		Arrays.fill(lis, -1);
		lis[0] = 1;
		for (int i = 1; i < array.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i] && lis[j] >= max) {
					max = lis[j] + 1;
					lis[i] = max;
				}
			}
			if (lis[i] == -1) {
				lis[i] = 1;
			}
		}
		int max = lis[0];
		for (int i = 1; i < lis.length; i++) {
			if (lis[i] > max) {
				max = lis[i];
			}
		}
		return max;
	}

}
