package com.vishal.string;


import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestPalin {

	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindromeOptimal(s));
	}

	public static String longestPalindromeOptimal(String s) {
		int maxLen = 0;
		String longestPalin = "";
		for(int i = 0; i < s.length(); i++){
			String palin = expandAroundTheMiddle(s, i, true);
			if(palin.length() > maxLen){
				longestPalin = palin;
				maxLen = palin.length();
			}
			palin = expandAroundTheMiddle(s, i, false);
			if(palin.length() > maxLen){
				longestPalin = palin;
				maxLen = palin.length();
			}
		}
		return longestPalin;
	}

	private static String expandAroundTheMiddle(String s, int index, boolean isOdd){
		int i = index;
		int j = -1;
		if(isOdd){
			j = index;
		}else{
			j = index+1;
		}
		while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
			i--;
			j++;
		}
		i++;
		return s.substring(i, j);
	}

	public String longestPalindrome(String s) {
		if(s.length() < 2){
			return s;
		}
		List<Map.Entry<Integer, Integer>> indicesEntryList = new LinkedList<>();
		for(int i = 0; i < s.length() - 1; i++){
			for(int j = i+1; j <= s.length(); j++){
				indicesEntryList.add(new AbstractMap.SimpleEntry<>(i, j));
			}
		}
		int max = 0;
		String outputStr = "";
		int resStart = -1, resEnd = -1;
		String[] indicesArr = new String[2];
		for(Map.Entry<Integer, Integer> entry: indicesEntryList){
			int start = entry.getKey();
			int end = entry.getValue();
			if(isPalindrome(s, start, end - 1) && (end-start) > max){
				resStart = start;
				resEnd = end;
				max = end-start;
			}
		}
		return s.substring(resStart, resEnd);
	}

	private static boolean isPalindrome(String s, int i, int j) {
		if (i > j) {
			return true;
		} else if (s.charAt(i) == s.charAt(j)) {
			return isPalindrome(s, i + 1, j - 1);
		} else {
			return false;
		}
	}
}
