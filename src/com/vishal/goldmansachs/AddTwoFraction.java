package com.vishal.goldmansachs;

public class AddTwoFraction {

	public static void main(String[] args) {
		int num1 = 1;
		int den1 = 3;
		int num2 = 3;
		int den2 = 9;
		int lcm = (den1 * den2) / gcd(den1, den2);
		int num = (lcm/den1)*num1 + (lcm/den2)*num2;
		System.out.println(num/gcd(num, lcm) + "/" + lcm/gcd(num, lcm));
		System.out.println();
	}

	private static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

}
