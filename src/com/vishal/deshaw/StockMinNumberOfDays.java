package com.vishal.deshaw;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StockMinNumberOfDays {

	public static void main(String args[]) {
		int currPrice = 20;
		int buyPrice = 82;
		Map<String, Integer> lookUp = new HashMap<>();
		Set<String> set = new HashSet<>();
		int days = getDays(currPrice, buyPrice, lookUp, set);
		System.out.println(days);
	}

	public static int getDays(int curr, int buy, Map<String, Integer> lookUp, Set<String> set) {
		String key = curr + "|" + buy;
		if (!set.contains(key)) {
			set.add(key);
		}
		if (lookUp.containsKey(key)) {
			return lookUp.get(key);
		} else if (curr < 0 || curr > 10000 || buy < 0 || buy > 10000) {
			return Integer.MAX_VALUE;
		} else if (curr >= buy) {
			return curr - buy;
		} else {
			int decByOne = Integer.MAX_VALUE;
			if(!set.contains(curr - 1 + "|" + buy)) {
				decByOne = getDays(curr - 1, buy, lookUp, set);
				decByOne = decByOne != Integer.MAX_VALUE ? decByOne + 1 : decByOne;
			}
			int incByDouble = Integer.MAX_VALUE;
			if (curr != 0 && (!set.contains(curr * 2 + "|" + buy))) {
				incByDouble = 1 + getDays(curr * 2, buy, lookUp, set);
			}
			lookUp.put(key, Math.min(decByOne, incByDouble));
		}
		return lookUp.get(key);

	}

}