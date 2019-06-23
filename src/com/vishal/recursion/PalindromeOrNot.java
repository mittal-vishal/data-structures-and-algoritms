package com.vishal.recursion;

public class PalindromeOrNot {
	
	public static boolean isPalin(String str, int start, int end) {
		double mid = Math.ceil((start+end)/2);
		if(str.charAt(start) == str.charAt(end) && end >= mid) {
			if(end == mid) {
				return true;
			}
			return isPalin(str, ++start, --end);
		}else {
			return false;
		}
	}

}
