package com.vishal.search;

public class FindSmallestDivisorGivenThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int beg = 1;
        int end = 0;
        for(int num: nums){
            end = Math.max(end, num);
        }
        int result = 0;
        while(beg <= end){
            int guess = beg + (end-beg)/2;
            if(isPossible(guess*1d, nums, threshold)){
                result = guess;
                end = guess-1;
            }else{
                beg = guess+1;
            }
        }
        return result;
    }

    private boolean isPossible(double guess, int[] nums, int threshold){
        int sum = 0;
        for(int num: nums){
            sum += Math.ceil(num/guess);
        }
        return sum <= threshold;
    }

}
