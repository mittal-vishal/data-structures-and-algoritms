package com.vishal.sachs.goldman;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaximumAverage {

	public static String getMaxAverageStudent(String[][] students) {
		int max = 0;
		String returnVal = null;
		Map<String, Entry<Integer, Integer>> studentsMap = new HashMap<>();
		for (String[] student : students) {
			if (!studentsMap.containsKey(student[0])) {
				studentsMap.put(student[0],
						new SimpleEntry<Integer, Integer>(Integer.parseInt(student[1]), 1));
			} else {
				Entry<Integer, Integer> entry = studentsMap.get(student[0]);
				studentsMap.remove(student[0]);
				studentsMap.put(student[0], new SimpleEntry<Integer, Integer>(
						Integer.parseInt(student[1]) + entry.getKey(), entry.getValue() + 1));
			}
		}
		for(Entry<String, Map.Entry<Integer, Integer>> mapEntry: studentsMap.entrySet()) {
			Entry<Integer, Integer> entry = mapEntry.getValue();
			if(entry.getKey()/entry.getValue() > max) {
				returnVal = mapEntry.getKey();
				max = entry.getKey()/entry.getValue();
			}
		}
		return returnVal;
	}

	public static void main(String[] args) {
		String students[][] = { { "jerry", "94" }, { "bob", "91" }, { "jerry", "80" }, { "Eric", "83" } };
		System.out.println(getMaxAverageStudent(students));
	}

}
