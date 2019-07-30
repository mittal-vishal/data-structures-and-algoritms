package com.vishal.walmart;

public class Factorial {
	
	public static long getFactorial(int number) {
		if(number > 1){
            return number*getFactorial(number-1);
        }else{
            return 1;
        }
	}
	
}
