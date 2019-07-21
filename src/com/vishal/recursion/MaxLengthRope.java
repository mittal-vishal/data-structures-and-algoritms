package com.vishal.recursion;

public class MaxLengthRope {

	public static int maxPieces(int n, int a, int b, int c) {

		if (n < 0) {
			return -1;
		} else if (n == 0) {
			return 0;
		}

		else {
			return 1 + maxOfThree(maxPieces(n - a, a, b, c), maxPieces(n - b, a, b, c), maxPieces(n - c, a, b, c));
		}

	}

	private static int maxOfThree(int a, int b, int c) {
		if (a >= b && a >= c) {
			return a;
		} else if (b >= a && b >= c) {
			return b;
		} else
			return c;
	}

}
