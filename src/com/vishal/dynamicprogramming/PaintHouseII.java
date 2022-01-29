package com.vishal.dynamicprogramming;

public class PaintHouseII {

    public int minCostII(int[][] costs) {
        if(costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[costs.length][k];
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            dp[0][i] = costs[0][i];
            if(costs[0][i] < min){
                secondMin = min;
                min = costs[0][i];
            }else if(costs[0][i] < secondMin){
                secondMin = costs[0][i];
            }
        }

        for(int i = 1; i < n; i++){
            int nmin = Integer.MAX_VALUE;
            int nsecondMin = Integer.MAX_VALUE;
            for(int j = 0; j < k; j++){
                if(dp[i-1][j] != min){
                    dp[i][j] = costs[i][j] + min;
                }else{
                    dp[i][j] = costs[i][j] + secondMin;
                }
                if(dp[i][j] < nmin){
                    nsecondMin = nmin;
                    nmin = dp[i][j];
                }else if(dp[i][j] < nsecondMin){
                    nsecondMin = dp[i][j];
                }
            }
            min = nmin;
            secondMin = nsecondMin;
        }
        int minCost = dp[costs.length-1][0];
        for(int i = 1; i < k; i++){
            minCost = Math.min(minCost, dp[costs.length - 1][i]);
        }
        return minCost;
    }

}
