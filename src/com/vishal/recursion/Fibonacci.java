package com.vishal.recursion;

public class Fibonacci {

	private static int first;
	private static int second;

	public static void printFibonacci(int n) {
		printFibonacci(n, 0);
	}

	private static void printFibonacci(int n, int i) {
		if (n > i) {
			if (i == 0) {
				first = i;
				System.out.println(first);
				printFibonacci(n, ++i);
			} else if (i == 1) {
				second = i;
				System.out.println(second);
				printFibonacci(n, ++i);
			} else {
				int third = first + second;
				System.out.println(third);
				first = second;
				second = third;
				printFibonacci(n, ++i);
			}
		}
	}

	public static void main(String[] args) {
		printFibonacci(10);
	}

}
