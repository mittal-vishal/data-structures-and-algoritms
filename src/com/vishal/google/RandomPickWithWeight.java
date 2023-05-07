package com.vishal.google;

import java.util.Random;

public class RandomPickWithWeight {

    class Solution {

        private int[] prefixSum;
        private int max;
        private Random random;

        public Solution(int[] w) {
            prefixSum = new int[w.length];
            prefixSum[0] = w[0];
            for(int i = 1; i < w.length; i++){
                prefixSum[i] = prefixSum[i-1] + w[i];
            }
            this.random = new Random();
            max = prefixSum[prefixSum.length-1];
        }

        public int pickIndex() {
            int random = 1 + this.random.nextInt(this.max);
            int beg = 0;
            int end = prefixSum.length-1;
            while(beg <= end){
                int mid = beg + (end-beg)/2;
                if(random == prefixSum[mid]){
                    return mid;
                }else if(random > prefixSum[mid]){
                    beg = mid+1;
                }else{
                    end = mid-1;
                }
            }
            return beg;
        }
    }

}
