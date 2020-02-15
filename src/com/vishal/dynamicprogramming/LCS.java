package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LCS {

	private static Map<String, Integer> lookup;

	public static void main(String[] args) {
		String s1 = "abcdgh";
		String s2 = "aedfhr";
		lookup = new HashMap<>();
		System.out.println(find(s1, s2, s1.length(), s2.length()));
	}

	private static int find(String s1, String s2, int m, int n) {
		String key = m + "|" + n;
		if (lookup.containsKey(key)) {
			return lookup.get(key);
		}
		if (m == 0 || n == 0) {
			lookup.put(key, 0);
		} else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			lookup.put(key, 1 + find(s1, s2, m - 1, n - 1));
		} else {
			lookup.put(key, Math.max(find(s1, s2, m - 1, n), find(s1, s2, m, n - 1)));
		}
		return lookup.get(key);
	}

}
