package com.vishal.string;

import java.util.List;

public class LongestWordInDictionaryAfterDeleting {

	public String findLongestWord(String s, List<String> d) {
		String resStr = "";
		for (String str : d) {
			if (isSubsequence(s, str)) {
				if (str.length() > resStr.length()) {
					resStr = str;
				} else if (str.length() == resStr.length()) {
					resStr = resStr.compareTo(str) < 0 ? resStr : str;
				}
			}
		}
		return resStr;
	}

	private boolean isSubsequence(String str, String resStr) {
		int j = resStr.length() - 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (j == 0 && str.charAt(i) == resStr.charAt(j)) {
				return true;
			}
			if (str.charAt(i) == resStr.charAt(j)) {
				j--;
			}
		}
		return false;
	}

}
