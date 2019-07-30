package com.vishal.walmart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortByOccurances {
	
	public static Map<Integer, Integer>sortByOccurances(int[] array) {
		Map<Integer, Integer> arrayMap = new  HashMap<>();
		Map<Integer, Integer> returnedMap = new  LinkedHashMap<>();
		for(int i : array) {
			if(arrayMap.containsKey(i)) {
				int arrayMapValue = arrayMap.get(i);
				arrayMap.remove(i);
				arrayMap.put(i, ++arrayMapValue);
			}else {
				arrayMap.put(i, 1);
			}
		}
		List<Entry<Integer, Integer>> arrayList = new ArrayList<>(arrayMap.entrySet());
		Comparator<Entry<Integer, Integer>> customComparator = new Comparator<Map.Entry<Integer,Integer>>() {
			
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		};
		Collections.sort(arrayList, customComparator);
		for(Entry<Integer, Integer> entry : arrayList) {
			returnedMap.put(entry.getKey(), entry.getValue());
		}
		return returnedMap;
	}

}
