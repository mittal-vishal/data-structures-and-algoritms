package com.vishal.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	private static List<String> returnList = new ArrayList<>();

	public static List<String> permute(String str) {
		return permute(str, 0, str.length() - 1);
	}

	public static List<String> permute(String str, int beg, int end) {
		if (beg == end) {
			returnList.add(str);
		} else {
			for (int i = beg; i <= end; i++) {
				str = swapCharacter(str, beg, i);
				permute(str, beg + 1, end);
			}
		}
		return returnList;
	}

	private static String swapCharacter(String str, int i, int j) {
		char charArray[] = str.toCharArray();
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	
	public static void main(String args[]) {
		System.out.println(permute("aab"));
	}

}
