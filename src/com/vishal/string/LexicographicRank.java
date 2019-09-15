package com.vishal.string;

import java.util.Arrays;

public class LexicographicRank {

	public static void main(String[] args) {
		String str = "string";
		System.out.println(find(str));
	}

	private static long find(String str) {
		if (str != null && !str.equals("")) {
			long rank = 1l;
			long fact = findFactorial(str.length());
			int charArray[] = new int[128];
			Arrays.fill(charArray, 0);
			for (int i = 0; i < str.length(); i++) {
				charArray[str.charAt(i)]++;
			}
			for (int i = 1; i < charArray.length; i++) {
				charArray[i] = charArray[i] + charArray[i - 1];
			}
			for (int i = 0; i < str.length(); i++) {
				fact = fact / (str.length() - i);
				rank = rank + (fact * charArray[str.charAt(i) - 1]);
				for (int j = str.charAt(i); j < charArray.length; j++) {
					charArray[j] = charArray[j] - 1;
				}
			}
			return rank;
		} else {
			return -1l;
		}
	}

	private static long findFactorial(int length) {
		if (length == 1) {
			return 1;
		} else if (length < 0) {
			return 0;
		} else {
			return length * findFactorial(length - 1);
		}
	}

}
