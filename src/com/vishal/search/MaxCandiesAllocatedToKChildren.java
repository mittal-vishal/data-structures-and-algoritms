package com.vishal.search;

public class MaxCandiesAllocatedToKChildren {

    public int maximumCandies(int[] candies, long k) {
        int beg = 1;
        int end = 0;
        for(int candy: candies){
            end = Math.max(end, candy);
        }
        int result = 0;
        while(beg <= end){
            int guess = beg + (end-beg)/2;
            if(isAllocationPossible(guess, candies, k)){
                result = guess;
                beg = guess + 1;
            }else{
                end = guess - 1;
            }
        }
        return result;
    }

    private boolean isAllocationPossible(int guess, int[] candies, long k){
        for(int i = 0; i < candies.length; i++){
            if(k <= 0){
                return true;
            }
            int capacity = candies[i];
            int totalStudent = capacity / guess;
            k -= totalStudent;
        }
        return k <= 0 ? true : false;
    }

}
