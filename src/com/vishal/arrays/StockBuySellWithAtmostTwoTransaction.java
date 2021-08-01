package com.vishal.arrays;

public class StockBuySellWithAtmostTwoTransaction {

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int minBuyFirst = Integer.MAX_VALUE;
        int minBuySecond = Integer.MAX_VALUE;
        int profitFirst = 0;
        int profitSecond = 0;

        for(int i = 0; i < prices.length; i++){
            minBuyFirst = Math.min(minBuyFirst, prices[i]);
            profitFirst = Math.max(profitFirst, prices[i] - minBuyFirst);
            minBuySecond = Math.min(minBuySecond, prices[i] - profitFirst);
            profitSecond = Math.max(profitSecond, prices[i] - minBuySecond);
        }

        return profitSecond;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.print(maxProfit(prices));
    }

}
