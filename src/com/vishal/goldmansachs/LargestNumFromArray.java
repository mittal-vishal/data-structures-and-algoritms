package com.vishal.goldmansachs;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargestNumFromArray {

	public static void main(String[] args) {
		int[] a = { 3, 30, 34, 5, 9 };
		System.out.println(largestNum(a));
	}

	private static String largestNum(int[] a) {
		List<Integer> list = IntStream.of(a).boxed().collect(Collectors.toList());
		Comparator<Integer> comp = (Integer o1, Integer o2) -> {
			String XY = String.valueOf(o1).concat(String.valueOf(o2));
			String YX = String.valueOf(o2).concat(String.valueOf(o1));
			return XY.compareTo(YX) > 0 ? -1 : 1;
		};
		Collections.sort(list, comp);
		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(i);
		}
		return sb.toString();
	}

}
