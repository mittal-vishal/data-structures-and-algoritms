package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class StockBuySellPartIV {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxProfit(prices, 0, 0, k, dp);
    }

    private int maxProfit(int[] prices, int index, int transaction, int k, int[][] dp){
        if(index == prices.length || transaction == (2*k)){
            return 0;
        }else if(dp[index][transaction] != -1){
            return dp[index][transaction];
        }else if(transaction % 2 == 0){
            //buy
            int withBuy = -prices[index] + maxProfit(prices, index+1, transaction+1, k, dp);
            int withoutBuy = maxProfit(prices, index+1, transaction, k, dp);
            dp[index][transaction] = Math.max(withBuy, withoutBuy);
            return dp[index][transaction];
        }else{
            //sell
            int withSell = prices[index] + maxProfit(prices, index+1, transaction+1, k, dp);
            int withoutSell = maxProfit(prices, index+1, transaction, k, dp);
            dp[index][transaction] = Math.max(withSell, withoutSell);
            return dp[index][transaction];
        }
    }

    public int maxProfitTabulation(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];
        for(int index = n-1; index >= 0; index--){
            for(int transaction = 2*k-1; transaction >= 0; transaction--){
                if(transaction % 2 == 0){
                    //buy
                    int withBuy = -prices[index] + dp[index+1][transaction+1];
                    int withoutBuy = dp[index+1][transaction];
                    dp[index][transaction] = Math.max(withBuy, withoutBuy);
                }else{
                    //sell
                    int withSell = prices[index] + dp[index+1][transaction+1];
                    int withoutSell = dp[index+1][transaction];
                    dp[index][transaction] = Math.max(withSell, withoutSell);
                }
            }
        }
        return dp[0][0];
    }

}
