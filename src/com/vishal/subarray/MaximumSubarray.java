package com.vishal.subarray;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarray {

	public static void main(String[] args) {
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(find(arr));

	}

	private static int find(int[] arr) {
		int currSum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			currSum = currSum + arr[i];
			max = Math.max(max, currSum);
			if (currSum < 0) {
				currSum = 0;
			}
		}
		return max;
	}

}
