package com.vishal.recursion;

public class FactorialTailRecursion {
	
	public static long getFactorial(int n, int result) {
		if(n <= 1) {
			return n*result;
		}
		return getFactorial(n-1, n*result);
	}
	
}
