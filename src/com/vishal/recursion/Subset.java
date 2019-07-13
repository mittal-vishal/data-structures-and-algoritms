package com.vishal.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {

	private static List<String> subsetList = new ArrayList<>();
	
	public static List<String> getSubset(String str){
		return getSubset("", str, 0, str.length()-1);
	}

	private static List<String> getSubset(String current, String str, int beg, int end) {
		if(beg <= end) {
			getSubset(current, str, beg + 1, end);
			current = current + str.charAt(beg);
			getSubset(current, str, beg + 1, end);
		}else {
			subsetList.add(current);
		}
		return subsetList;
	}
	
}
