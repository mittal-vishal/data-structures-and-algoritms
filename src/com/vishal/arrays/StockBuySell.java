package com.vishal.arrays;

public class StockBuySell {

	public static void main(String[] args) {
		int a[] = { 3,3,5,0,0,3,1,4 };
		System.out.print(maxProfitWithOneTransaction(a));
	}

	public static int maxProfitWithOneTransaction(int[] prices) {
		if(prices == null || prices.length < 2){
			return 0;
		}

		int min = Integer.MAX_VALUE;
		int maxProfit = 0;

		for(int i = 0; i < prices.length; i++){
			if(prices[i] < min){
				min = prices[i];
			}else{
				maxProfit = Math.max(maxProfit, prices[i] - min);
			}
		}
		return maxProfit;
	}

	public static int maxProfitWithManyTransaction(int[] prices) {
		if(prices == null || prices.length < 2){

		}
		int profit = 0;
		for(int i = 1; i < prices.length; i++){
			if(prices[i-1] < prices[i]){
				profit += (prices[i] - prices[i-1]);
			}
		}
		return profit;
	}

}
