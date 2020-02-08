package com.vishal.arrays;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 10;
		print(n);
	}
	
	private static void print(int n) {
		int n1 = 0; 
		int n2 = 1;
		int n3;
		System.out.print(n1 + " ");
		System.out.print(n2+ " ");
		for(int i=0;i<n-2;i++) {
			n3 = n1 + n2;
			System.out.print(n3 + " ");
			n1 = n2;
			n2 = n3;
		}
	}

}
