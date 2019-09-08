package com.vishal.sorting;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int a[] = { 1, 4, 1, 2, 7, 5, 2 };
		a = sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static int[] sort(int[] a) {
		int range[] = new int[10];
		int output[] = new int[a.length];
		Arrays.fill(range, 0);
		for(int i = 0; i<a.length;i++) {
			range[a[i]]++;
		}
		for(int i = 1; i<range.length;i++) {
			range[i] = range[i] + range[i-1];
		}
		for(int i = 0; i<a.length;i++) {
			output[range[a[i]]-1] = a[i];
			range[a[i]] = range[a[i]]-1;
		}
		return output;
	}

}
