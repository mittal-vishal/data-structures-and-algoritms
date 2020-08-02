package com.vishal.dynamicprogramming;

public class LIS {

	public static void main(String[] args) {
		int[] array = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(array));
	}

	public static int lengthOfLIS(int[] nums) {
        int next = Integer.MAX_VALUE;
        return lengthOfLIS(nums, nums.length - 1, next);
    }
    
    private static int lengthOfLIS(int[] nums, int n, int next) {
        if(n < 0){
            return 0;
        }else if(nums[n] >= next){
            return lengthOfLIS(nums, n - 1, next);
        }else{
            return Math.max(1 + lengthOfLIS(nums, n - 1, nums[n]), lengthOfLIS(nums, n - 1, next));
        }
    }

}
