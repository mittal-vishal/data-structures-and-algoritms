package com.vishal.string;

public class NaivePatternSearch {

	public static void main(String[] args) {
		String str = "abcdabcabcd";
		String pattern = "abc";
		find(str, pattern);
	}

	private static void find(String str, String pattern) {
		int n = str.length(), m = pattern.length();
		for(int i=0;i<n-m+1;i++) {
			int k = i;
			for(int j=0;j<m;j++) {
				if(str.charAt(k) == pattern.charAt(j)) {
					k++;
				}else {
					break;
				}
				if(j == m-1) {
					System.out.println(i);
				}
			}
		}
	}

}
