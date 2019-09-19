package com.vishal.string;

public class RotatoryStrings {

	public static void main(String[] args) {
		String str = "abcd";
		String rotatoryStr = "cdab";
		System.out.println(find(str, rotatoryStr));
	}

	private static boolean find(String str, String rotatoryStr) {
		if (str.concat(str).indexOf(rotatoryStr) >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
