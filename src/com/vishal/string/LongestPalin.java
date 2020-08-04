package com.vishal.string;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestPalin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();
			System.out.print(findLongestPalin(str));
		}
		sc.close();
	}

	private static String findLongestPalin(String str){
	     Set<String> subStrSet = new LinkedHashSet<>();
	     for(int i = 0; i < str.length(); i++){
	         for(int j = i + 1; j <= str.length(); j++){
	             subStrSet.add(str.substring(i,j));
	         }
	     }
	     int max = Integer.MIN_VALUE;
	     String returnStr = null;
	     for(String st : subStrSet){
	         if(isPalin(st, 0, st.length() - 1) && st.length() > max){
	             max = st.length();
	             returnStr = st;
	         }
	     }
	     return returnStr;
	 }

	private static boolean isPalin(String s, int i, int j) {
		if (i > j) {
			return true;
		} else if (s.charAt(i) == s.charAt(j)) {
			return isPalin(s, i + 1, j - 1);
		} else {
			return false;
		}
	}
}
