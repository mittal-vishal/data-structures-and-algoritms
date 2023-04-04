package com.vishal.string;

public class NaivePatternSearch {

	public static void main(String[] args) {
		String str = "abcdabcabcd";
		String pattern = "abc";
		strStr(str, pattern);
	}

	public static int strStr(String haystack, String needle) {
		int n = haystack.length();
		int m = needle.length();
		int j = 0;
		if(needle.length() > haystack.length()){
			return -1;
		}
		for(int i = 0; i < n; i++){
			int k = i;
			while(j < m && k < n){
				if(haystack.charAt(k) == needle.charAt(j)){
					k++;
					j++;
				}else{
					j = 0;
					break;
				}
				if(j == m){
					return k-j;
				}
			}
		}
		return -1;
	}

}