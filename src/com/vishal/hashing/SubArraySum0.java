package com.vishal.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArraySum0 {

	public static void main(String[] args) {
		int a[] = {2,9,-5,4,1,7};
		System.out.println(find(a));
	}

	private static boolean find(int[] a) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum = sum + a[i];
			if(set.contains(sum) || sum == 0) {
				return true;
			}else {
				set.add(sum);
			}
		}
		return false;
	}

}
