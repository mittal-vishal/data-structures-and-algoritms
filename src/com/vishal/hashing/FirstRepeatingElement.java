package com.vishal.hashing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class FirstRepeatingElement {

	public static void main(String[] args) {
		int a[] = { 5, 6, 8, 3, 6, 8, 5, 6, 6 };
		System.out.println(find(a));
	}

	private static int find(int[] a) {
		Map<Integer, Entry<Integer, Integer>> hashMap = new LinkedHashMap<>();
		int value = 0, index = 0;
		for(int i=0;i<a.length;i++) {
			if(!hashMap.containsKey(a[i])) {
				hashMap.put(a[i], new SimpleEntry<>(i, 1));
			}else {
				value = hashMap.get(a[i]).getValue();
				index = hashMap.get(a[i]).getKey();
				hashMap.put(a[i], new SimpleEntry<>(index, value + 1));
			}
		}
		for(Entry<Integer, Entry<Integer, Integer>> entry : hashMap.entrySet()) {
			if(entry.getValue().getValue() > 1) {
				return entry.getValue().getKey() + 1;
			}
		}
		return -1;
	}

}
