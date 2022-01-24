package com.vishal.dynamicprogramming;

public class LIS {

	public static void main(String[] args) {
		int[] array = {10,9,2,5,3,7,101,18};
		LIS lis = new LIS();
		System.out.println(lis.lengthOfLIS(array));
	}

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int maxLIS = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return maxLIS;

    }

}
