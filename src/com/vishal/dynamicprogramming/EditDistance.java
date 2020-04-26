package com.vishal.dynamicprogramming;

public class EditDistance {

	public static void main(String[] args) {
		String s1 = "saturday";
		String s2 = "sunday";
		System.out.println(find(s1, s2, s1.length(), s2.length()));
	}

	private static int find(String s1, String s2, int m, int n) {
		if (m == 0 && n == 0) {
			return 0;
		} else if (n == 0 && m != 0) {
			return m;
		} else if (m == 0 && n != 0) {
			return n;
		}else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return find(s1, s2, m - 1, n - 1);
		} else {
			return 1 + getMin(find(s1, s2, m, n - 1), find(s1, s2, m - 1, n), find(s1, s2, m - 1, n - 1));
		}
	}

	private static int getMin(int i, int j, int k) {
		if (i < j && i < k) {
			return i;
		} else if (j < i && j < k) {
			return j;
		} else {
			return k;
		}
	}

}
