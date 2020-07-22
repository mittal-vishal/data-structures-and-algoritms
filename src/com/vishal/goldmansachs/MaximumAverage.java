package com.vishal.goldmansachs;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaximumAverage {

	public static int getMaxAverageStudent(String[][] students) {
		Map<String, Entry<Integer, Integer>> studentMap = new HashMap<>();
		Entry<Integer, Integer> existedEntry = null;
		for(String[] student : students) {
			if(!studentMap.containsKey(student[0])) {
				studentMap.put(student[0], new SimpleEntry<Integer, Integer>(Integer.valueOf(student[1]), 1));
			}else {
				existedEntry = studentMap.get(student[0]);
				studentMap.put(student[0], new SimpleEntry<Integer, Integer>(Integer.valueOf(existedEntry.getKey() + Integer.valueOf(student[1])), existedEntry.getValue() + 1));
			}
		}
		int maxScore = Integer.MIN_VALUE;
		Entry<Integer, Integer> marksEntry = null;
		for(Entry<String, Entry<Integer, Integer>> entry : studentMap.entrySet()) {
			marksEntry = entry.getValue();
			if(marksEntry.getKey() / marksEntry.getValue() > maxScore) {
				maxScore = marksEntry.getKey() / marksEntry.getValue();
			}
		}
		return maxScore;
	}

	public static void main(String[] args) {
		String students[][] = { { "jerry", "94" }, { "bob", "91" }, { "jerry", "80" }, { "Eric", "83" } };
		System.out.println(getMaxAverageStudent(students));
	}

}
