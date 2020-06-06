package com.vishal.arrays;

import java.util.Scanner;

public class NearestPerfectSquare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			System.out.println(getNearestPerfectSquare(sc.nextDouble()));
		}
		sc.close();
	}

	private static long getNearestPerfectSquare(double n) {
		long smallerNum = (long) (isPerfectSquare(n) ? Math.sqrt(n) - 1 : Math.floor(Math.sqrt(n)));
		long greaterNum = (long) (isPerfectSquare(n) ? Math.sqrt(n) + 1 : Math.ceil(Math.sqrt(n)));

		if (n - (smallerNum * smallerNum) < (greaterNum * greaterNum) - n) {
			return smallerNum * smallerNum;
		} else {
			return greaterNum * greaterNum;
		}
	}

	private static boolean isPerfectSquare(double n) {
		if (Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n))) {
			return true;
		} else {
			return false;
		}
	}

}
