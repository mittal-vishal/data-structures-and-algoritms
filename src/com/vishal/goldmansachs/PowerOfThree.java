package com.vishal.goldmansachs;

public class PowerOfThree {

	public boolean isPowerOfThree(int n) {
		double num = n;

		if (num == 1d) {
			return true;
		}

		while (num > 1d) {
			num = num / 3;
			if (num == 1d) {
				return true;
			}
		}

		return false;

	}

}
