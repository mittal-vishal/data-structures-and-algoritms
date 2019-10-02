package com.vishal.hashing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WinnerOfAnElection {

	public static void main(String[] args) {
		String arr[] = { "john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny",
				"jamie", "johnny", "john" };
		find(arr, arr.length);
	}

	private static void find(String[] arr, int length) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		int oldValue = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				oldValue = map.get(arr[i]);
				map.put(arr[i], oldValue + 1);
			}
		}
		int max = Integer.MIN_VALUE;
		String voter = "";
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				voter = entry.getKey();
			} else if (entry.getValue() == max) {
				if (voter.compareTo(entry.getKey()) > 0) {
					voter = entry.getKey();
				}
			}
		}
		System.out.println(voter + " " + max);
	}

}
