package com.vishal.arrays;

import java.util.Arrays;

public class StockBuySellPartIII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxProfit(prices, 0, 0, dp);
    }

    private int maxProfit(int[] prices, int index, int transaction, int[][] dp){
        if(index == prices.length || transaction == 4){
            return 0;
        }else if(dp[index][transaction] != -1){
            return dp[index][transaction];
        }else if(transaction % 2 == 0){
            //buy
            int withBuy = -prices[index] + maxProfit(prices, index+1, transaction+1, dp);
            int withoutBuy = maxProfit(prices, index+1, transaction, dp);
            dp[index][transaction] = Math.max(withBuy, withoutBuy);
            return dp[index][transaction];
        }else{
            //sell
            int withSell = prices[index] + maxProfit(prices, index+1, transaction+1, dp);
            int withoutSell = maxProfit(prices, index+1, transaction, dp);
            dp[index][transaction] = Math.max(withSell, withoutSell);
            return dp[index][transaction];
        }
    }

}
