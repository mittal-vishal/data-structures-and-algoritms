package com.vishal.hashing;

import java.util.HashSet;
import java.util.Set;

public class Intersection {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6};
		int b[] = {3,4,5,6,7};
		System.out.println(find(a,b));
	}

	private static int find(int[] a, int[] b) {
		Set<Integer> hashSet = new HashSet<>();
		for(int i=0;i<a.length;i++) {
			hashSet.add(a[i]);
		}
		int count = 0;
		for(int i=0;i<b.length;i++) {
			if(hashSet.contains(b[i])) {
				count++;
				hashSet.remove(b[i]);
			}
		}
		return count;
	}

}
