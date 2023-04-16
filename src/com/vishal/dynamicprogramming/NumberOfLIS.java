package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class NumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLIS = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    count[i] = count[j];
                }else if(nums[i] > nums[j] && dp[j]+1 == dp[i]){
                    count[i] += count[j];
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxLIS){
                result += count[i];
            }
        }
        return result;
    }

}
