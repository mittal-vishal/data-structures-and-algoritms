package com.vishal.amazon;

import java.util.Arrays;

public class CountPossibleTriangles {

	public static void main(String[] args) {
		int a[] = { 6, 4, 9, 7, 8 };
		Arrays.sort(a);
		System.out.println(find(a, a.length));
	}

	private static int find(int[] a, int length) {
		int count = 0;
		for(int i = length-1; i > 1; i--) {
			int l = 0, r = i-1;
			while(l < r) {
				if(a[l] + a[r] > a[i]) {
					count = count + (r-l);
					r--;
				}else {
					l++;
				}
			}
		}
		return count;
	}

}
