package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return countWays(amount, coins, n-1, dp);
    }

    private int countWays(int amount, int[] coins, int index, int[][] dp){
        if(index == 0){
            if(amount % coins[index] == 0){
                return 1;
            }else{
                return 0;
            }
        }else if(dp[index][amount] != -1){
            return dp[index][amount];
        }else{
            int include = 0;
            if(coins[index] <= amount){
                include = countWays(amount-coins[index], coins, index, dp);
            }
            int exclude = countWays(amount, coins, index-1, dp);
            dp[index][amount] = include+exclude;
            return dp[index][amount];
        }
    }

    public int changeTabulation(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int target = 0; target <= amount; target++){
            if(target % coins[0] == 0){
                dp[0][target] = 1;
            }else{
                dp[0][target] = 0;
            }
        }
        for(int i = 1; i < n; i++){
            for(int target = 0; target <= amount; target++){
                int include = 0;
                if(coins[i] <= target){
                    include = dp[i][target-coins[i]];
                }
                int exclude = dp[i-1][target];
                dp[i][target] = include+exclude;
            }
        }
        return dp[n-1][amount];
    }

    public int changeSpaceOptimised(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        for(int target = 0; target <= amount; target++){
            if(target % coins[0] == 0){
                prev[target] = 1;
            }else{
                prev[target] = 0;
            }
        }
        for(int i = 1; i < n; i++){
            for(int target = 0; target <= amount; target++){
                int include = 0;
                if(coins[i] <= target){
                    include = curr[target-coins[i]];
                }
                int exclude = prev[target];
                curr[target] = include+exclude;
            }
            prev = curr;
        }
        return prev[amount];
    }

}
