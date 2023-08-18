package com.vishal.search;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int beg = 1;
        int end = Integer.MIN_VALUE;
        for(int pile: piles){
            end = Math.max(end, pile);
        }
        int result = end;
        while(beg <= end){
            int guess = beg + (end-beg)/2;
            if(isPossible(piles, h, guess)){
                result = guess;
                end = guess-1;
            }else{
                beg = guess+1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] piles, int h, int guess){
        int currHour = 0;
        for(int pile: piles){
            currHour += Math.ceil(pile*1d/guess*1d);
        }
        return currHour <= h;
    }

}
