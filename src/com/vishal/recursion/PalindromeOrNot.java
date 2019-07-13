package com.vishal.recursion;

public class PalindromeOrNot {

	public static boolean isPalin(String str, int start, int end) {
		if (str == null || str == "") {
			return false;
		}
		double mid = Math.ceil(str.length() / 2);
		if (start >= mid || mid > end) {
			return true;
		}
		if (str.charAt(start) == str.charAt(end)) {
			return isPalin(str, ++start, --end);
		}else {
			return false;
		}
	}

}
