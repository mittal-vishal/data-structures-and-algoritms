package com.vishal.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {

	public static void main(String[] args) {
		int a[] = {3, 1, 3, 3, 2};
		System.out.println(find(a, a.length));
	}

	private static int find(int[] a, int size) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i=0;i<size;i++) {
			if(!hashMap.containsKey(a[i])) {
				hashMap.put(a[i], 1);
			}else {
				int oldOccurance = hashMap.get(a[i]);
				hashMap.put(a[i], ++oldOccurance);
			}
		}
		for(Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if(entry.getValue() > (size/2)) {
				return entry.getKey();
			}
		}
		return -1;
	}

}
