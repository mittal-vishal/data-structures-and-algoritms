package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class PaintHouseII {

    private int INT_MAX = (int)1e8;

    public int minCostII(int[][] costs) {
        int n = costs.length;
        int m = costs[0].length;
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int j = 0; j < m; j++){
            int minCost = getMinCost(costs, 0, j, null, dp);
            result = Math.min(result, minCost);
        }
        return result;
    }

    private int getMinCost(int[][] costs, int i, int j, Integer prev, int[][] dp){
        if(prev != null && prev == j){
            return INT_MAX;
        }else if(i == costs.length-1){
            return costs[i][j];
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }
        int minCost = INT_MAX;
        for(int k = 0; k < costs[0].length; k++){
            int currCost = costs[i][j] + getMinCost(costs, i+1, k, j, dp);
            minCost = Math.min(minCost, currCost);
        }
        return dp[i][j] = minCost;
    }

}
