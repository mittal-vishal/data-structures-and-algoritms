package com.vishal.dynamicprogramming;

public class ReachGivenScore {

	public static void main(String[] args) {
		int n = 20;
		int[] scores = {3, 5, 10};
		System.out.println(reach(n, scores, scores.length-1));
	}

	private static int reach(int n, int[] scores, int length) {
		if(n == 0) {
			return 1;
		}else if(n < 0 || length < 0) {
			return 0;
		}else if(n < scores[length]) {
			return reach(n, scores, length - 1);
		}else {
			return reach(n - scores[length], scores, length) + reach(n, scores, length - 1);
		}
	}
	
}
