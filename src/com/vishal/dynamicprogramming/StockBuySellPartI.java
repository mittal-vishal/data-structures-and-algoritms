package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class StockBuySellPartI {

    public static void main(String[] args) {
        int a[] = { 3,3,5,0,0,3,1,4 };
        System.out.print(maxProfitWithOneTransaction(a));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return getProfit(prices, 0, 0, dp);
    }

    private int getProfit(int[] prices, int index, int transaction, int[][] dp){
        if(transaction == 2 || index == prices.length){
            return 0;
        }else if(dp[index][transaction] != -1){
            return dp[index][transaction];
        }else if(transaction == 0){
            //BUY scenario
            int profitWithBuy = -prices[index] + getProfit(prices, index+1, transaction+1, dp);
            int profitWithoutBuy = getProfit(prices, index+1, transaction, dp);
            return dp[index][transaction] = Math.max(profitWithBuy, profitWithoutBuy);
        }else{
            ////SELL scenario
            int profitWithSell = prices[index] + getProfit(prices, index+1, transaction+1, dp);
            int profitWithoutSell = getProfit(prices, index+1, transaction, dp);
            return dp[index][transaction] = Math.max(profitWithSell, profitWithoutSell);
        }
    }

    public static int maxProfitWithOneTransaction(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            int currentProfit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, currentProfit);
            minBuy = Math.min(minBuy, prices[i]);
        }
        return maxProfit;
    }

    public static int maxProfitWithOneTransaction1(int[] prices) {
        int[] profit = new int[prices.length];
        int n = prices.length;
        profit[n-1] = prices[n-1];
        int maxProfit = prices[n-1];
        for(int i = n-2; i >= 0; i--){
            maxProfit = Math.max(maxProfit, prices[i]);
            profit[i] = maxProfit;
        }
        maxProfit = 0;
        for(int i = 0; i < n; i++){
            maxProfit = Math.max(maxProfit, profit[i] - prices[i]);
        }
        return maxProfit;
    }

}
