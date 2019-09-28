package com.vishal.hashing;

import java.util.HashSet;
import java.util.Set;

public class PairSum {

	public static void main(String[] args) {
		int a[] = {12,4,5,-1,3,-6,3,1};
		int item = -3;
		System.out.println(find(a, item));
	}

	private static boolean find(int[] a, int item) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<a.length;i++) {
			if(set.contains(item - a[i])) {
				return true;
			}else {
				set.add(a[i]);
			}
		}
		return false;
	}

}
