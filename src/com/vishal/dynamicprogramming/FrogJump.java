package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class FrogJump {

    private static int frogJump(int n, int[] heights){
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minEnergy(n, heights, dp);
    }

    private static int minEnergy(int n, int[] heights, int[] dp){
        if(n == 0){
            return 0;
        }else if(dp[n] != -1){
            return dp[n];
        }
        int oneJump = minEnergy(n-1, heights, dp) + Math.abs(heights[n]-heights[n-1]);
        int twoJump = Integer.MAX_VALUE;
        if(n > 1){
            twoJump = minEnergy(n-2, heights, dp) + Math.abs(heights[n]-heights[n-2]);
        }
        dp[n] = Math.min(oneJump, twoJump);
        return dp[n];
    }

    public static int frogJumpTabulation(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;
        for(int jump = 1; jump < n; jump++){
            int oneJump = dp[jump-1] + Math.abs(heights[jump]-heights[jump-1]);
            int twoJump = Integer.MAX_VALUE;
            if(jump > 1){
                twoJump = dp[jump-2] + Math.abs(heights[jump]-heights[jump-2]);
            }
            dp[jump] = Math.min(oneJump, twoJump);
        }
        return dp[n-1];
    }

    public static int frogJumpSpaceOptimised(int n, int heights[]) {
        int prev1 = 0;
        int prev2 = 0;
        for(int jump = 1; jump < n; jump++){
            int oneJump = prev1 + Math.abs(heights[jump]-heights[jump-1]);
            int twoJump = Integer.MAX_VALUE;
            if(jump > 1){
                twoJump = prev2 + Math.abs(heights[jump]-heights[jump-2]);
            }
            int curr = Math.min(oneJump, twoJump);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }



}
