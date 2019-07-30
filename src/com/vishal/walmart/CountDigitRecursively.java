package com.vishal.walmart;

public class CountDigitRecursively {
	
	public static int countDigitOfNumber(int number) {
		if(number > 0) {
			return 1 + countDigitOfNumber(number/10);
		}else {
			return 0;
		}
	}

}
