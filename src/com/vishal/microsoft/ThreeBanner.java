package com.vishal.microsoft;

import java.util.PriorityQueue;

public class ThreeBanner {

    public int maximumProfit(int[] A, int[] B, int[] C){
        int profit = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int smallBanner = A[0];
        int mediumBanner = A[1];
        int largeBanner = A[2];
        for(int i = 0; i < B.length; i++){
            pq.offer(new int[]{B[i], i});
        }
        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int currPrice = polled[0];
            int shopNumber = polled[1];
            int totalBanner = C[shopNumber] / 10;
            int bannerType = C[shopNumber] % 10;
            if(bannerType == 2 && totalBanner <= largeBanner && largeBanner > 0){
                profit += (currPrice * totalBanner);
                largeBanner -= totalBanner;
            }else if(bannerType == 1 && totalBanner <= (largeBanner + mediumBanner)
                    && (largeBanner + mediumBanner) > 0){
                profit += (currPrice * totalBanner);
                if(totalBanner <= mediumBanner){
                    mediumBanner -= totalBanner;
                    totalBanner = 0;
                }else{
                    if(mediumBanner > 0){
                        totalBanner -= mediumBanner;
                        mediumBanner = 0;
                    }
                    while(largeBanner > 0){
                        largeBanner--;
                        totalBanner--;
                    }
                }
            }else if(bannerType == 0 && totalBanner <= (largeBanner + mediumBanner + smallBanner)
                && (largeBanner + mediumBanner + smallBanner) > 0){
                profit += (currPrice * totalBanner);
                if(totalBanner <= smallBanner){
                    smallBanner -= totalBanner;
                    totalBanner = 0;
                }else{
                    if(smallBanner > 0){
                        totalBanner -= smallBanner;
                        smallBanner = 0;
                    }
                    while(mediumBanner > 0){
                        mediumBanner--;
                        totalBanner--;
                    }
                    while(largeBanner > 0){
                        largeBanner--;
                        totalBanner--;
                    }
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3};
        int[] B = {4,5,6};
        int[] C = {10,21,32};
        ThreeBanner banner = new ThreeBanner();
        int maxProfit = banner.maximumProfit(A, B, C);
        System.out.println(maxProfit);
    }

}
