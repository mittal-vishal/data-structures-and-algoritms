package com.vishal.goldmansachs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumFromArray {

	public static void main(String[] args) {
		int[] a = { 3, 30, 34, 5, 9 };
		System.out.println(getGreatestNum(a));
	}

	private static String getGreatestNum(int[] num) {
		StringBuilder sb = new StringBuilder();
		List<Integer> list = Arrays.stream(num).boxed().collect(Collectors.toList());

		Collections.sort(list, (o1, o2) -> {
			String s1 = String.valueOf(o1).concat(String.valueOf(o2));
			String s2 = String.valueOf(o2).concat(String.valueOf(o1));
			return s1.compareTo(s2) > 0 ? -1 : 1;
		});

		for (int i : list) {
			sb.append(i);
		}

		return sb.toString();
	}

}
