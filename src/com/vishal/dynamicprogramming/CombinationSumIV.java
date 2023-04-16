package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return countWays(nums, target, dp);
    }

    private int countWays(int[] nums, int target, int[] dp){
        if(target == 0){
            return 1;
        }else if(target < 0){
            return 0;
        }else if(dp[target] != -1){
            return dp[target];
        }else{
            int result = 0;
            for(int i = 0; i < nums.length; i++){
                result += countWays(nums, target - nums[i], dp);
            }
            return dp[target] = result;
        }
    }

}
