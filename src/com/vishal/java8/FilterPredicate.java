package com.vishal.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterPredicate {

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(12);
		arrayList.add(1);
		arrayList.add(9);
		arrayList.add(40);
		arrayList.add(52);
		arrayList.add(7);
		Predicate<Integer> pred = o1 -> o1>5 && o1 < 20;
		arrayList.stream().filter(pred).forEach(r  -> System.out.println(r));
	}

}
