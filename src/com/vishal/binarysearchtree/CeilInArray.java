package com.vishal.binarysearchtree;

import java.util.TreeSet;

public class CeilInArray {
	
	public static void main(String[] args) {
		int a[] = {2, 8, 30, 15, 25, 12};
		findOptimal(a);
	}

	private static void find(int[] a) {
		for(int i = 0; i < a.length; i++) {
			int ceil = Integer.MAX_VALUE;
			for(int j = i-1;j>=0;j--) {
				if(a[j] >= a[i] && a[j] < ceil) {
					ceil = a[j];
				}
			}
			if(ceil == Integer.MAX_VALUE) {
				System.out.println("-1");
			}else {
				System.out.println(ceil);
			}
		}
	}
	
	private static void findOptimal(int[] a) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(a[0]);
		System.out.println(-1);
		for(int i = 1; i < a.length; i++) {
			if(set.ceiling(a[i]) != null) {
				System.out.println(set.ceiling(a[i]));
			}else {
				System.out.println(-1);
			}
			set.add(a[i]);
		}
	}

}
