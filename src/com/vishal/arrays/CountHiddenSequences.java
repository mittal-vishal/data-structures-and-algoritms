package com.vishal.arrays;

public class CountHiddenSequences {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long start = lower;
        long max = start;
        long min = start;
        for(int diff: differences){
            start += diff;
            max = Math.max(max, start);
            min = Math.min(min, start);
        }
        long ans = (upper - lower) - (max - min)  + 1;
        if(ans < 0){
            ans = 0;
        }
        return (int)ans;
    }

}
