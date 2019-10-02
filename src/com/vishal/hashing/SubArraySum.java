package com.vishal.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArraySum {

	public static void main(String[] args) {
		int a[] = {2,9,-5,4,1,7};
		int item = 12;
		System.out.println(find(a, item));
	}

	private static boolean find(int[] a, int x) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		set.add(0);
		for(int i=0;i<a.length;i++) {
			sum = sum + a[i];
			if(set.contains(sum - x)) {
				return true;
			}else {
				set.add(sum);
			}
		}
		return false;
	}

}
