package com.vishal.arrays;

public class StockBuySellWithManyTransaction {

	public static void main(String[] args) {
		int a[] = { 3,3,5,0,0,3,1,4 };
		System.out.print(maxProfitWithManyTransaction(a));
	}

	public static int maxProfitWithManyTransaction(int[] prices) {
		if(prices == null || prices.length < 2){
			return 0;
		}
		int profit = 0;
		int minBuy = Integer.MAX_VALUE;
		for(int i = 0; i < prices.length; i++){
			if(prices[i] < minBuy){
				minBuy = prices[i];
			}else{
				profit += prices[i] - minBuy;
				minBuy = prices[i];
			}
		}
		return profit;
	}

}
