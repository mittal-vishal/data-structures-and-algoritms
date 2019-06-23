package com.vishal.recursion;

public class Factorial {
	
	public static long getFactorial(int n) {
		if(n <= 1) {
			return 1;
		}
		return n*getFactorial(n-1);
	}

}
