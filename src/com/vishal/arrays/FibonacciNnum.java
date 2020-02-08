package com.vishal.arrays;

public class FibonacciNnum {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(print(n));
	}
	
	private static int print(int n) {
		int n1 = 0; 
		int n2 = 1;
		int n3 = 0;
		int count = 2;
		if(n == 0) {
			return n1;
		}else if(n == 1) {
			return n2;
		}else{
			for(int i=0;i<n-2;i++) {
				n3 = n1 + n2;
				count ++;
				if(count == n) {
					break;
				}
				n1 = n2;
				n2 = n3;
			}
			return n3;
		}
	}

}
