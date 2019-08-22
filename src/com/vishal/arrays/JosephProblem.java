package com.vishal.arrays;

import java.util.List;

public class JosephProblem {

	public static int joseph(List<Integer> arrayList, int k) {
		int l = 0;
		while (arrayList.size() != 1) {
			int i = (l == 0) ? (k - 1) % arrayList.size() : l % arrayList.size();
			arrayList.remove(i);
			l = i + k-1;
		}
		return arrayList.get(0);
	}

}
