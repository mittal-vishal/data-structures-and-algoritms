package com.vishal.search;

public class MinTimeToCompleteTrips {

    public long minimumTime(int[] time, int totalTrips) {
        int maxTime = 0;
        for(int i = 0; i < time.length; i++){
            maxTime = Math.max(maxTime, time[i]);
        }
        long beg = 1;
        long end = (long)maxTime*totalTrips;
        long result = 0;
        while(beg <= end){
            long guess = beg + (end-beg)/2;
            if(canCompleteTrips(time, totalTrips, guess)){
                result = guess;
                end = guess-1;
            }else{
                beg = guess+1;
            }
        }
        return result;
    }

    private boolean canCompleteTrips(int[] time, int totalTrips, long guessTime){
        long possibleTrips = 0;
        for(int i = 0; i < time.length; i++){
            possibleTrips += guessTime/time[i];
        }
        return possibleTrips >= totalTrips;
    }

}
