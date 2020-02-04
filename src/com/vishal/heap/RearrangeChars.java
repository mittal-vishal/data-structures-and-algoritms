package com.vishal.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class RearrangeChars {

	private static Comparator<HeapStruc> comparator;

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		comparator = new Comparator<HeapStruc>() {
			@Override
			public int compare(HeapStruc o1, HeapStruc o2) {
				return o2.occurance - o1.occurance;
			}
		};
		System.out.println(reArrange(str));
	}

	public static boolean reArrange(String str) {
		boolean isRearrange = true;
		PriorityQueue<HeapStruc> pq = new PriorityQueue<>(comparator);
		Map<Character, Integer> map = getOccurances(str);
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			pq.add(new HeapStruc(entry.getKey(), entry.getValue()));
		}
		String res = "";
		HeapStruc obj1 = null;
		HeapStruc obj2 = null;
		while (!pq.isEmpty()) {
			obj1 = pq.poll();
			res = res + obj1.getCharacter();
			if (!pq.isEmpty()) {
				obj2 = pq.poll();
				res = res + obj2.getCharacter();
			}
			if (obj1 != null && obj1.getOccurance() > 1) {
				pq.add(new HeapStruc(obj1.getCharacter(), obj1.getOccurance() - 1));
			}
			if (obj2 != null && obj2.getOccurance() > 1) {
				pq.add(new HeapStruc(obj2.getCharacter(), obj2.getOccurance() - 1));
			}
		}
		for (int i = 0; i < res.length() - 1; i++) {
			if (res.charAt(i) == res.charAt(i + 1)) {
				isRearrange = false;
			}
		}
		return isRearrange;
	}

	private static Map<Character, Integer> getOccurances(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
		}
		return map;
	}

}
