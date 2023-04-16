package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class StockBuySellPartII {

	public static void main(String[] args) {
		int a[] = { 3,3,5,0,0,3,1,4 };
		System.out.print(maxProfitWithManyTransaction(a));
	}

	public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];
		for(int i = 0; i < prices.length; i++){
			Arrays.fill(dp[i], -1);
		}
		return maxProfit(prices, 0, 1, dp);
	}

	private int maxProfit(int[] prices, int index, int buy, int[][] dp){
		if(index == prices.length){
			return 0;
		}else if(dp[index][buy] != -1){
			return dp[index][buy];
		}else if(buy == 1){
			int withBuy = -prices[index] + maxProfit(prices, index + 1, 0, dp);
			int withoutBuy = maxProfit(prices, index + 1, 1, dp);
			dp[index][buy] = Math.max(withBuy, withoutBuy);
			return dp[index][buy];
		}else{
			//If sell
			int withSell = prices[index] + maxProfit(prices, index + 1, 1, dp);
			int withoutSell = maxProfit(prices, index + 1, 0, dp);
			dp[index][buy] = Math.max(withSell, withoutSell);
			return dp[index][buy];
		}
	}

	public static int maxProfitWithManyTransaction(int[] prices) {
		int maxProfit = 0;
		for(int i = 1; i < prices.length; i++){
			if(prices[i] - prices[i-1] > 0){
				maxProfit += (prices[i] - prices[i-1]);
			}
		}
		return maxProfit;
	}

}
