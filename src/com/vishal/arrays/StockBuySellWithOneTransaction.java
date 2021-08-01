package com.vishal.arrays;

public class StockBuySellWithOneTransaction {

    public static void main(String[] args) {
        int a[] = { 3,3,5,0,0,3,1,4 };
        System.out.print(maxProfitWithOneTransaction(a));
    }

    public static int maxProfitWithOneTransaction(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }

        int minBuy = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minBuy){
                minBuy = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - minBuy);
            }
        }
        return maxProfit;
    }

}
