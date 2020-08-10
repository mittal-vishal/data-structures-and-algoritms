package com.vishal.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
	
	public static void main(String[] args) {
		System.out.println(getSubset("abc"));
	}
	
	public static List<String> getSubset(String str){
		List<String> subsetList = new ArrayList<>();
		return getSubset(str, "", subsetList);
	}

	private static List<String> getSubset(String str, String current, List<String> subList) {
		if(str.length() == 0) {
			subList.add(current);
		}else {
			getSubset(str.substring(1), current, subList);
			getSubset(str.substring(1), current + str.charAt(0), subList);
		}
		return subList;
	}
	
}
