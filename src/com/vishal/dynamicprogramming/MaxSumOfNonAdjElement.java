package com.vishal.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumOfNonAdjElement {

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, -1);
        return sum(nums, nums.size()-1, dp);
    }

    public static int maximumNonAdjacentSumTabulation(ArrayList<Integer> nums) {
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        for(int i = 1; i < nums.size(); i++){
            int pick = nums.get(i);
            if(i > 1){
                pick += dp[i-2];
            }
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[nums.size()-1];
    }

    private static int sum(ArrayList<Integer> nums, int index, int[] dp){
        if(index < 0){
            return 0;
        }else if(index == 0){
            return nums.get(0);
        }else if(dp[index] != -1){
            return dp[index];
        }
        int include = nums.get(index) + sum(nums, index - 2, dp);
        int exclude = sum(nums, index - 1, dp);
        return dp[index] = Math.max(include, exclude);
    }

}
