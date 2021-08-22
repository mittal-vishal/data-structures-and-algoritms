package com.vishal.walmart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByOccurances {

	private static int[] sortByOccurances(int[] nums) {
		HashMap<Integer, Integer> numOccurMap = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			numOccurMap.put(nums[i], numOccurMap.getOrDefault(nums[i], 0) + 1);
		}
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList(numOccurMap.entrySet());
		Collections.sort(entryList, (a,b) -> {
			if(a.getValue() != b.getValue()){
				return a.getValue() - b.getValue();
			}else{
				return b.getKey() - a.getKey();
			}
		});
		int[] res = new int[nums.length];
		int index = 0;
		for(Map.Entry<Integer, Integer> entry: entryList){
			for(int i = 0; i < entry.getValue(); i++){
				res[index++] = entry.getKey();
			}
		}
		return res;
	}

	public static void main(String args[]) {
		int a[] = { 9, 2, 5, 2, 7, 7, 2, 9, 2, 9, 9 };
		sortByOccurances(a);
	}

}
