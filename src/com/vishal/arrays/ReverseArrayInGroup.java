package com.vishal.arrays;

public class ReverseArrayInGroup {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int result[] = reverse(a, a.length, 3);
		for (int i : result) {
			System.out.println(i);
		}
	}

	private static int[] reverse(int[] a, int n, int k) {
		return reverse(a, 0, n, k, 0);
	}

	private static int[] reverse(int[] a, int i, int n, int k, int l) {
		if (i < n) {
			l = l == 0 ? k : l;
			for(int j = i; j < ((i + l) / 2) && l <= n; j++) {
				int temp = a[j];
				a[j] = a[l - 1];
				a[l - 1] = temp;
				l--;
			}
			i = i + k;
			l = i + k;
			return reverse(a, i, n, k, l);
		} else {
			return a;
		}

	}

}
