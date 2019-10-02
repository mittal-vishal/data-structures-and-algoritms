package com.vishal.hashing;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RelativeSorting {

	public static void main(String[] args) {
		int a[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int b[] = {2,1,8,3};
		sort(a,b);

	}

	private static void sort(int[] a, int[] b) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for(int i : a) {
			if(!map.containsKey(i)) {
				map.put(i, 1);
			}else {
				map.put(i, map.get(i) + 1);
			}
		}
		Comparator<Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer,Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		};
		List<Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, comparator);
		Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
		for(Entry<Integer, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		int count = 0;
		for(int i : b) {
			count = sortedMap.containsKey(i) ? sortedMap.get(i) : 0;
			while(count > 0) {
				System.out.print(i + " ");
				count--;
			}
			sortedMap.remove(i);
		}
		for(Entry<Integer, Integer> entry : sortedMap.entrySet()) {
			count = entry.getValue();
			while(count > 0) {
				System.out.print(entry.getKey() + " ");
				count--;
			}
		}
	}

}
