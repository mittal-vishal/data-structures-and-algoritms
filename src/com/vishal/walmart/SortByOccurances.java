package com.vishal.walmart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortByOccurances {

	private static void sortByOccurances(int[] array) {
		Map<Integer, Integer> arrayMap = new HashMap<>();
		for (int i : array) {
			if (arrayMap.containsKey(i)) {
				int arrayMapValue = arrayMap.get(i);
				arrayMap.remove(i);
				arrayMap.put(i, ++arrayMapValue);
			} else {
				arrayMap.put(i, 1);
			}
		}
		
		List<Entry<Integer, Integer>> arrayList = new ArrayList<>(arrayMap.entrySet());
		Comparator<Entry<Integer, Integer>> customComparator = (Entry<Integer, Integer> o1,
				Entry<Integer, Integer> o2) -> o2.getValue().compareTo(o1.getValue());
		Collections.sort(arrayList, customComparator);
		
		for (Entry<Integer, Integer> entry : arrayList) {
			int count = entry.getValue();
			while (count > 0) {
				System.out.print(entry.getKey() + " ");
				count--;
			}
		}
	}

	public static void main(String args[]) {
		int a[] = { 9, 2, 5, 2, 7, 7, 2, 9, 2, 9, 9 };
		sortByOccurances(a);
	}

}
