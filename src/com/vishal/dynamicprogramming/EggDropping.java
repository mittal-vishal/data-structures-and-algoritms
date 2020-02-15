package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class EggDropping {
	
	private static Map<String, Integer> map;

	public static void main(String[] args) {
		int n = 2;
		int k = 4; 
		map = new HashMap<>();
		System.out.println(find(n, k));
	}

	private static int find(int n, int k) {
		String key = n + "|" + k;
		if(map.containsKey(key)) {
			return map.get(key);
		}
		if(n == 1) {
			return k;
		}
		if(k == 0 || k == 1) {
			return k;
		}
		int min = Integer.MAX_VALUE;
		int attempt = 0;
		for(int i=1;i<=k;i++) {
			attempt = Math.max(find(n-1, i-1) , find(n, k-i)) + 1;
			if(attempt < min) {
				min = attempt;
			}
			map.put(key, min);
		}
		return min;
	}
	
	

}
