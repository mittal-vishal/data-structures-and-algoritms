package com.vishal.arrays;

public class TrappingRainWater {

	/**
	 * Tapp rain with complexity O(n^2).
	 *
	 * @param a the a
	 * @return the int
	 */
	public static int trapRain(int a[]) {
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
	public static int trap(int[] height) {
		if(height == null || height.length < 3){
			return 0;
		}
		int[] maxLeft = new int[height.length];
		int[] maxRight = new int[height.length];
		int maxL = height[0];
		int maxR = height[height.length-1];

		for(int i  = 1; i < height.length - 1; i++){
			maxLeft[i] = maxL;
			maxL = Math.max(maxL, height[i]);
		}

		for(int i  = height.length - 1; i > 0; i--){
			maxRight[i] = maxR;
			maxR = Math.max(maxR, height[i]);
		}

		int trappedWater = 0;
		int depth = 0;
		for(int i = 1; i < height.length - 1; i++){
			depth = Math.min(maxLeft[i], maxRight[i]) - height[i];
			trappedWater += ((depth < 0) ? 0: depth);
		}
		return trappedWater;
	}

	public static void main(String[] args) {
		int a[] = { 3, 5, 1, 0, 7 };
		System.out.println(trap(a));
	}

}
