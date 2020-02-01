package com.vishal.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectWithFiltering {

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(12);
		arrayList.add(1);
		arrayList.add(9);
		arrayList.add(40);
		arrayList.add(52);
		arrayList.add(7);
		arrayList = arrayList.stream().filter(getPredicate()).collect(Collectors.toList());
		System.out.println(arrayList);
	}
	
	private static Predicate<Integer> getPredicate(){
		return p -> p > 10 && p < 50;
	}
	
}
