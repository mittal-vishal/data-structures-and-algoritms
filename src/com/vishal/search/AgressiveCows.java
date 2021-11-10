package com.vishal.search;

public class AgressiveCows {

    public static void main(String[] args) {
        int[] stalls = {1,2,4,8,9};
        int k = 3;
        AgressiveCows cows = new AgressiveCows();
        int minDist = cows.findMaxDistance(stalls, k);
        System.out.print(minDist);
    }

    private int findMaxDistance(int[] stalls, int k) {
        int low = 1;
        int maxPos = stalls[0];
        int minPos = stalls[0];
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] > maxPos){
                maxPos = stalls[i];
            }
            if(stalls[i] < minPos){
                minPos = stalls[i];
            }
        }
        int high = maxPos - minPos;
        int max = 1;
        while(low <= high){
            int guess = low + (high - low)/2;
            if(isPossible(stalls, guess, k)){
                max = Math.max(max, guess);
                low = guess + 1;
            }else{
                high = guess - 1;
            }
        }
        return max;
    }

    private boolean isPossible(int[] stalls, int guess, int cows){
        int prev = 0;
        cows = cows - 1;
        for(int i = 1; i < stalls.length && cows > 0; i++){
            if((stalls[i] - stalls[prev]) >= guess){
                cows--;
                prev = i;
                continue;
            }
        }
        if(cows > 0){
            return false;
        }else{
            return true;
        }
    }

}
