package com.vishal.recursion;

public class JosephProblem {

	public static void main(String[] args) {
		System.out.println(joseph(7, 3));
	}

	public static int joseph(int n, int k) {
		if (n == 1) {
			return 0;
		} else {
			return (joseph(n - 1, k) + k) % n;
		}
	}
}
