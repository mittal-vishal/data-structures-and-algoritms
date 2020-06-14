package com.vishal.arrays;

public class TrappingRainWater {

	/**
	 * Tapp rain with complexity O(n^2).
	 *
	 * @param a the a
	 * @return the int
	 */
	public static int tappRain(int a[]) {
		int returnVal = 0;
		for (int i = 1; i < a.length - 1; i++) {
			int leftMax = 0;
			int rightMax = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] > leftMax) {
					leftMax = a[j];
				}
			}
			for (int k = i + 1; k < a.length; k++) {
				if (a[k] > rightMax) {
					rightMax = a[k];
				}
			}
			returnVal += Math.abs((leftMax < rightMax ? leftMax : rightMax) - a[i] < 0 ? 0
					: (leftMax < rightMax ? leftMax : rightMax) - a[i]);
		}
		return returnVal;
	}

	/**
	 * Tapp rain water with complexity O(n).
	 *
	 * @param a the a
	 * @return the int
	 */
	public static int tappRainWater(int rain[]) {
		int[] leftMaxima = new int[rain.length];
		int[] rightMaxima = new int[rain.length];
		int leftMax = 0;
		for (int i = 0; i < rain.length; i++) {
			if (rain[i] > leftMax) {
				leftMaxima[i] = leftMax;
				leftMax = rain[i];
			} else {
				leftMaxima[i] = leftMax;
			}
		}
		int rightMax = 0;
		for (int i = rain.length - 1; i >= 0; i--) {
			if (rain[i] > rightMax) {
				rightMaxima[i] = rightMax;
				rightMax = rain[i];
			} else {
				rightMaxima[i] = rightMax;
			}
		}
		int trappedWater = 0;
		for (int i = 1; i < rain.length - 1; i++) {
			if ((Math.min(rightMaxima[i], leftMaxima[i]) - rain[i]) > 0) {
				trappedWater = trappedWater + (Math.min(rightMaxima[i], leftMaxima[i]) - rain[i]);
			}
		}
		return trappedWater;
	}

	public static void main(String[] args) {
		int a[] = { 3, 5, 1, 0, 7 };
		System.out.println(tappRainWater(a));
	}

}
