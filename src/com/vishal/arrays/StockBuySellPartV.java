package com.vishal.arrays;

import java.util.Arrays;

public class StockBuySellPartV {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxProfit(prices, 0, 0, dp);
    }

    private int maxProfit(int[] prices, int index, int buy, int[][] dp){
        if(index >= prices.length){
            return 0;
        }else if(dp[index][buy] != -1){
            return dp[index][buy];
        }else if(buy == 0){
            int withBuy = -prices[index] + maxProfit(prices, index + 1, 1, dp);
            int withoutBuy = maxProfit(prices, index + 1, 0, dp);
            dp[index][buy] = Math.max(withBuy, withoutBuy);
            return dp[index][buy];
        }else{
            //sell
            int withSell = prices[index] + maxProfit(prices, index + 2, 0, dp);
            int withoutSell = maxProfit(prices, index+1, 1, dp);
            dp[index][buy] = Math.max(withSell, withoutSell);
            return dp[index][buy];
        }
    }

}
