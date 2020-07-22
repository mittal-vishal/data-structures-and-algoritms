package com.vishal.subarray;

public class MinSubarrayWithSum {
	public static void main(String[] args) {
		int arr1[] = { 1, 5, 45, 6, 10, 19 };
		int item = 51;
		System.out.println(smallestSubWithSum(arr1, 6, item));
	}

	private static int smallestSubWithSum(int arr[], int n, int item) {
		// Initialize current sum and minimum length
		int curr_sum = 0, min_len = n + 1;

		// Initialize starting and ending indexes
		int start = 0, end = 0;
		while (end < n) {
			// Keep adding array elements while current sum
			// is smaller than x
			while (curr_sum <= item && end < n) {
				curr_sum += arr[end++];
				if (curr_sum == item) {
					min_len = end - start;
				}
			}

			// If current sum becomes greater than x.
			while (curr_sum > item && start < n) {
				// remove starting elements
				curr_sum -= arr[start++];

				// Update minimum length if needed
				if (curr_sum == item && end - start < min_len)
					min_len = end - start;
			}
		}
		return min_len;
	}
}
