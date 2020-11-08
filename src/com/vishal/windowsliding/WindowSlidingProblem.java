package com.vishal.windowsliding;

public class WindowSlidingProblem {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
		int k = 4;
		System.out.println(find(arr, k));

	}

	private static int find(int[] arr, int k) {
		if (arr.length < k) {
			return -1;
		}
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + arr[i];
		}
		for (int i = k; i < arr.length; i++) {
			sum = Math.max(sum, sum + arr[i] - arr[i - k]);
		}
		return sum;
	}

}
