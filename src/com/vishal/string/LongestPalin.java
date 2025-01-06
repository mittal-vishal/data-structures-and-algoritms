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
		//for each index, expand around the corner to get the palindrome
		String result = "";
		for(int i = 0; i < s.length(); i++){
			//for odd length
			String palinOddLength = expandAroundCMiddle(s, i, i);
			if(palinOddLength.length() > result.length()){
				result = palinOddLength;
			}
			//for even length
			String palinEvenLength = expandAroundCMiddle(s, i, i+1);
			if(palinEvenLength.length() > result.length()){
				result = palinEvenLength;
			}
		}
		return result;
	}

	private static String expandAroundCMiddle(String s, int i, int j){
		int left = 0;
		int right = s.length()-1;
		while(i >= left && j <= right){
			if(s.charAt(i) == s.charAt(j)){
				i--;
				j++;
			}else{
				break;
			}
		}
		return s.substring(i+1, j);
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
