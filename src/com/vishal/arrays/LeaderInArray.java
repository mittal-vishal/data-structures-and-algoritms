package com.vishal.arrays;

import java.util.LinkedList;
import java.util.List;

public class LeaderInArray {

	public static List<Integer> getLeaders(int a[]) {
		List<Integer> linkedList = new LinkedList<>();
		int min = 0;
		for (int i = a.length - 1; i > 0; i--) {
			if (a[i] >= a[min] || i == a.length - 1) {
				linkedList.add(a[i]);
			}
			if (a[i - 1] > a[i]) {
				min = i - 1;
			}
		}
		return linkedList;
	}

}
