package com.vishal.search;

public class MinDaysToMakeMBouquet {

    public int minDays(int[] bloomDay, int m, int k) {
        //Base condition
        long value = (long) m*k;
        if(value > bloomDay.length){
            return -1;
        }
        //calculate min & max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < bloomDay.length; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        //Apply binary search
        int beg = min, end = max;
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            if(isPossible(bloomDay, mid, m, k)){
                end = mid - 1;
            }else{
                beg = mid + 1;
            }
        }
        return beg;
    }

    private boolean isPossible(int[] bloomDay, int days, int m, int k){
        int count = 0;
        int numOfBouquet = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(days >= bloomDay[i]){
                count++;
            }else{
                numOfBouquet += (count/k);
                count = 0;
            }
        }
        numOfBouquet += (count/k);
        return numOfBouquet >= m;
    }

}
