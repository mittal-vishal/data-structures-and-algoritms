package com.vishal.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBallons {

    private static int INT_MIN = (int)-1e8;

    public int maxCoins(int[] nums) {
        List<Integer> ballons = new ArrayList<>();
        ballons.add(1);
        for(int i = 0; i < nums.length; i++){
            ballons.add(nums[i]);
        }
        ballons.add(1);
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i = 0; i <= nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxCoins(ballons, 1, ballons.size()-2, dp);
    }

    private int maxCoins(List<Integer> ballons, int i, int j, int[][] dp){
        if(i > j){
            return 0;
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }
        int result = INT_MIN;
        for(int index = i; index <= j; index++){
            int cost = ballons.get(i-1) * ballons.get(index) * ballons.get(j+1) + maxCoins(ballons, i, index-1 ,dp)
                    + maxCoins(ballons, index+1, j, dp);
            result = Math.max(result, cost);
        }
        return dp[i][j] = result;
    }

}
