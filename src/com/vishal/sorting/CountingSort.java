package com.vishal.sorting;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int a[] = { 4, 5, 2, 3, 5, 2, 3, 8 };
		a = sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static int[] sort(int[] a) {
		int min = a[0];
		int max = a[0];
		for(int i = 0; i < a.length; i++){
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}
		int range = max - min + 1;
		int occur[] = new int[range];
		int output[] = new int[a.length];

		for(int i = 0; i < a.length; i++) {
			int pos = a[i] - min;
			occur[pos]++;
		}
		for(int i = 1; i < occur.length;i++) {
			occur[i] = occur[i] + occur[i-1];
		}
		for(int i = a.length - 1; i >= 0; i--) {
			int pos = a[i] - min;
			int correctIdx = occur[pos] - 1;
			output[correctIdx] = a[i];
			occur[pos]--;
		}
		return output;
	}

}
