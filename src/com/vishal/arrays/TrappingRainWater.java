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
	public static int tappRainWater(int a[]) {
		int returnVal = 0;
		int leftMaxArray[] = new int[a.length];
		int rightMaxArray[] = new int[a.length];
		int leftMax = 0, rightMax = 0;
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				leftMaxArray[i] = 0;
				leftMax = a[0];
			} else if (a[i] > leftMax) {
				leftMaxArray[i] = leftMax;
				leftMax = a[i];
			} else {
				leftMaxArray[i] = leftMax;
			}
		}
		for (int i = a.length - 1; i > 0; i--) {
			if (i == a.length - 1) {
				rightMaxArray[i] = 0;
				rightMax = a[a.length - 1];
			} else if (a[i] > rightMax) {
				rightMaxArray[i] = rightMax;
				rightMax = a[i];
			} else {
				rightMaxArray[i] = rightMax;
			}
		}
		for (int i = 0; i < a.length; i++) {
			returnVal += Math
					.abs((leftMaxArray[i] < rightMaxArray[i] ? leftMaxArray[i] : rightMaxArray[i]) - a[i] < 0 ? 0
							: (leftMaxArray[i] < rightMaxArray[i] ? leftMaxArray[i] : rightMaxArray[i]) - a[i]);
		}
		return returnVal;
	}

	public static void main(String[] args) {
		int a[] = { 3, 5, 1, 0, 7 };
		System.out.println(tappRainWater(a));
	}

}
