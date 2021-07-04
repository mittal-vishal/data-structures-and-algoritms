package com.vishal.subarray;

public class MinSubarrayWithSum {
	public static void main(String[] args) {
		int arr1[] = { 1, 5, 45, 6, 10, 19 };
		int item = 51;
		System.out.println(minSubArrayLen(arr1, item));
	}

	public static int minSubArrayLen(int[] nums, int target) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int sum = 0;
		int left = 0, right = 0;
		int min = nums.length + 1;
		while(right < nums.length){
			//Expand the window
			sum += nums[right++];
			//shrink the window and update the answer
			while(sum >= target && left < right){
				min = Math.min(min,(right - left));
				sum -= nums[left++];
			}
		}
		return min != nums.length + 1 ? min : 0;
	}

}
