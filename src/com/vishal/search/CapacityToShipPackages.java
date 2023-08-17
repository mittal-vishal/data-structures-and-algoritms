package com.vishal.search;

public class CapacityToShipPackages {

    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;
        for(int weight: weights){
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        int beg = maxWeight;
        int end = totalWeight;
        int result = 0;
        while(beg <= end){
            int guess = beg + (end-beg)/2;
            if(isPossible(weights, days, guess)){
                result = guess;
                end = guess-1;
            }else{
                beg = guess+1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] weights, int days, int capacity){
        int currWeight = 0;
        int i = 0;
        while(i < weights.length && days > 0){
            while(currWeight <= capacity && i < weights.length){
                currWeight += weights[i];
                i++;
            }
            if(currWeight > capacity){
                i--;
            }
            days--;
            currWeight = 0;
        }
        if(i < weights.length){
            return false;
        }
        return true;
    }

}
