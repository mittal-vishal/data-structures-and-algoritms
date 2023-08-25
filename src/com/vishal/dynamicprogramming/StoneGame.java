package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class StoneGame {

    public boolean stoneGame(int[] piles) {
        int total = 0;
        for(int pile: piles){
            total += pile;
        }
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int alice = getMaxScore(piles, 0, piles.length-1, dp);
        int bob = total - alice;
        return alice > bob;
    }

    private int getMaxScore(int[] piles, int i, int j, int[][] dp){
        if(i > j){
            return 0;
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }
        int pickLeft = piles[i] + getMaxScore(piles, i+1, j, dp);
        int pickRight = piles[j] + getMaxScore(piles, i, j-1, dp);
        return dp[i][j] = Math.max(pickLeft, pickRight);
    }

}
