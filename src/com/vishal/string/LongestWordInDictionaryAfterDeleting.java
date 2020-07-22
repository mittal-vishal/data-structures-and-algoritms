package com.vishal.string;

import java.util.List;

public class LongestWordInDictionaryAfterDeleting {

	public static String findLongestWord(String s, List<String> d) {
		String resStr = "";
		for (String str : d) {
			if (isSubSequence(str, s)) {
				if (str.length() > resStr.length()) {
					resStr = str;
				} else if (str.length() == resStr.length()) {
					resStr = resStr.compareTo(str) < 0 ? resStr : str;
				}
			}
		}
		return resStr;
	}

	private static boolean isSubSequence(String word, String str) {
		int wordStartI = 0;
		int strStartI = 0;
		while (wordStartI < word.length() && strStartI < str.length()) {
			if (word.charAt(wordStartI) == str.charAt(strStartI)) {
				wordStartI++;
				strStartI++;
			} else {
				strStartI++;
			}
		}
		return wordStartI == word.length();
	}

}
