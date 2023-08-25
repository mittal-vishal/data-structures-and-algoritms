package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class StoneGameII {

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[2][n+1][n+1];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j <= n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        int alice = getMaxScore(piles, 0, 1, 0, dp);
        return alice;
    }

    private int getMaxScore(int[] piles, int i, int m, int turn, int[][][] dp){
        if(i == piles.length){
            return 0;
        }else if(dp[turn][i][m] != -1){
            return dp[turn][i][m];
        }
        int res = turn == 0? Integer.MIN_VALUE: Integer.MAX_VALUE;
        int score = 0;
        for(int x = 1; x <= Math.min(2*m, piles.length-i); x++){
            score += piles[i+x-1];
            if(turn == 0){
                res = Math.max(res, score + getMaxScore(piles, i+x, Math.max(m, x), 1, dp));
            }else{
                res = Math.min(res, getMaxScore(piles, i+x, Math.max(m, x), 0, dp));
            }
        }
        return dp[turn][i][m] = res;
    }

}
