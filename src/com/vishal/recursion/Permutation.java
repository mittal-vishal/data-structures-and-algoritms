package com.vishal.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	private static List<String> returnList = new ArrayList<>();
	
	public static void main(String args[]) {
		permutation("abc", "");
		System.out.println(returnList);
	}

	private static void permutation(String str, String output) {
		if (str.length() == 0) {
			returnList.add(output);
		}
		for (int i = 0; i < str.length(); i++) {
			String ros = str.substring(0, i) + str.substring(i + 1);
			permutation(ros, output + str.charAt(i));
		}
	}

}
