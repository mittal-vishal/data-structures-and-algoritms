package com.vishal.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MostFrequencyElement {

	public static void main(String[] args) {
		int a[] = { 5, 6, 8, 3, 6, 8, 5, 6, 6 };
		System.out.println(find(a));
	}

	private static int find(int[] a) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int value = 0;
		for(int i=0;i<a.length;i++) {
			if(!hashMap.containsKey(a[i])) {
				hashMap.put(a[i], 1);
			}else {
				value = hashMap.get(a[i]);
				hashMap.put(a[i], value + 1);
			}
		}
		int max = Integer.MIN_VALUE;
		int returnValue = 0;
		for(Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if(entry.getValue() > max) {
				max = entry.getValue();
				returnValue = entry.getKey();
			}
		}
		return returnValue;
	}

}
