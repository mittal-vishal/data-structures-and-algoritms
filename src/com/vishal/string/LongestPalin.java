package com.vishal.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestPalin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();
			System.out.print(find(str));
		}
		sc.close();
	}

	private static String find(String str) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				list.add(str.substring(i, j));
			}
		}
		int max = Integer.MIN_VALUE;
		String returnStr = "";
		for (String s : list) {
			if (isPalin(s, 0, s.length() - 1) && s.length() > max) {
				max = s.length();
				returnStr = s;
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
