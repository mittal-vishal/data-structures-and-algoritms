package com.vishal.subarray;

public class MaximumSubarraySum {

	public static void main(String[] args) {
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(arr));

	}

	public static int maxSubArray(int[] nums) {
		int currSum = 0;
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++){
			currSum += nums[i];
			res = Math.max(res, currSum);
			if(currSum < 0){
				currSum = 0;
			}
		}
		return res;
	}
}
