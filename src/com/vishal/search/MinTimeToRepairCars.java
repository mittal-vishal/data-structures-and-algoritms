package com.vishal.search;

public class MinTimeToRepairCars {

    public long repairCars(int[] ranks, int cars) {
        long beg = 1;
        int maxRank = 0;
        for(int rank: ranks){
            maxRank = Math.max(rank, maxRank);
        }
        long end = (maxRank * 1l) * cars * cars;
        long result = 0;
        while(beg <= end){
            long guess = beg + (end-beg)/2;
            if(isPossible(guess, ranks, cars)){
                result = guess;
                end = guess-1;
            }else{
                beg = guess+1;
            }
        }
        return result;
    }

    private boolean isPossible(long time, int[] ranks, int cars){
        long totalCars = 0;
        for(int i = 0; i < ranks.length; i++){
            int currRank = ranks[i];
            long currCar = time/currRank;
            totalCars += (long) Math.sqrt(currCar);
        }
        return totalCars >= cars;
    }

}
