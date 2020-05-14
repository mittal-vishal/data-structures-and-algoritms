package com.vishal.goldmansachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGrouping {

	public static void main(String[] args) {
		String[] strs = { "", "", "" };
		System.out.println(groupAnagrams(strs));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		List<List<String>> retList = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		String sorted = null;
		char[] strArray = new char[strs.length];
		for (String str : strs) {
			strArray = str.toCharArray();
			Arrays.sort(strArray);
			sorted = String.valueOf(strArray);
			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<>());
			}
			map.get(sorted).add(str);
		}
		retList.addAll(map.values());
		return retList;
	}

}
