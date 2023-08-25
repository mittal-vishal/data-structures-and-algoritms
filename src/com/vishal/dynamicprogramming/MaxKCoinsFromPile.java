package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class MaxKCoinsFromPile {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxValue(piles, 0, k, dp);
    }

    private int maxValue(List<List<Integer>> piles, int i, int k, int[][] dp){
        if(i == piles.size() || k == 0){
            return 0;
        }else if(dp[i][k] != -1){
            return dp[i][k];
        }
        int exclude = maxValue(piles, i+1, k, dp);
        int include = 0;
        int currPile = 0;
        for(int j = 0; j < Math.min(piles.get(i).size(), k); j++){
            currPile += piles.get(i).get(j);
            include = Math.max(include, currPile + maxValue(piles, i+1, k-j-1, dp));
        }
        return dp[i][k] = Math.max(include, exclude);
    }

}
