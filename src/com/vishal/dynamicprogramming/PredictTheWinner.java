package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class PredictTheWinner {

    public boolean predictTheWinner(int[] nums) {
        if(nums.length < 2){
            return true;
        }
        int totalScore = 0;
        for(int num: nums){
            totalScore += num;
        }
        int[][][] dp = new int[2][nums.length][nums.length];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < nums.length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        int player1 = maxScore(nums, 0, 0, nums.length-1, dp);
        int player2 = totalScore - player1;
        return player1 >= player2;
    }

    private int maxScore(int[] nums, int turn, int i, int j, int[][][] dp){
        if(i > j){
            return 0;
        }else if(dp[turn][i][j] != -1){
            return dp[turn][i][j];
        }
        if(turn == 0){
            int left = nums[i] + maxScore(nums, 1, i+1, j, dp);
            int right = nums[j] + maxScore(nums, 1, i, j-1, dp);
            return dp[turn][i][j] = Math.max(left, right);
        }else{
            int left = maxScore(nums, 0, i+1, j, dp);
            int right = maxScore(nums, 0, i, j-1, dp);
            return dp[turn][i][j] = Math.min(left, right);
        }
    }

}
