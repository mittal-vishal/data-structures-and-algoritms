package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class FrogJumpKStep {

    private static int frogJump(int n, int[] heights){
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int k = 3;
        return minEnergy(n, k, heights, dp);
    }

    private static int minEnergy(int n, int k, int[] heights, int[] dp){
        if(n == 0){
            return 0;
        }else if(dp[n] != -1){
            return dp[n];
        }
        int minEnergy = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            if((n-i) >= 0){
                int jump = minEnergy(n-i, k, heights, dp) + Math.abs(heights[n-i]-heights[n]);
                minEnergy = Math.min(jump, minEnergy);
            }
        }
        dp[n] = minEnergy;
        return dp[n];
    }

    private static int minEnergyTabulation(int n, int k, int[] heights){
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if ((i-j) >= 0) {
                    int jump = dp[i-j] + Math.abs(heights[i-j] - heights[i]);
                    minEnergy = Math.min(jump, minEnergy);
                }
            }
            dp[i] = minEnergy;
        }
        return dp[n];
    }

}
