package com.vishal.arrays;

import java.util.Arrays;

public class StockBuySellWithKTransaction {

    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length < 2 || k < 1){
            return 0;
        }
        int n  = prices.length;
        if(k >= n/2){
            return maxProfitUsingNTransactions(prices, n);
        }else{
            return maxProfitUsingKTransactions(prices, k, n);
        }
    }

    private int maxProfitUsingNTransactions(int[] prices, int n){
        int minBuy = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < n; i++){
            if(prices[i] < minBuy){
                minBuy = prices[i];
            }else{
                profit += prices[i] - minBuy;
                minBuy = prices[i];
            }
        }
        return profit;
    }

    private int maxProfitUsingKTransactions(int[] prices, int k, int n){
        int[] minBuy = new int[k];
        Arrays.fill(minBuy, Integer.MAX_VALUE);
        int[] profit = new int[k];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                minBuy[j] = Math.min(minBuy[j], prices[i] - (j == 0 ? 0: profit[j-1]));
                profit[j] = Math.max(profit[j], prices[i] - minBuy[j]);
            }
        }
        return profit[k-1];
    }

}
