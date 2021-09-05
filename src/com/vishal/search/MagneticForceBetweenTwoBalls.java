package com.vishal.search;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    public int maxDistance(int[] position, int m) {
        int minF = 1;
        Arrays.sort(position);
        int maxF = position[position.length - 1] - position[0];
        int max = 1;

        while(minF <= maxF){
            int mid = minF + (maxF-minF)/2;
            if(isPossible(position, m, mid)){
                max = Math.max(max, mid);
                minF = mid + 1;
            }else{
                maxF = mid - 1;
            }
        }

        return max;
    }

    private boolean isPossible(int[] position, int m, int guess){
        int currBallsCount = 1;
        int prevPos = 0;
        for(int i = 1; i < position.length; i++){
            if(position[i] - position[prevPos] >= guess){
                currBallsCount++;
                if(currBallsCount == m){
                    return true;
                }
                prevPos = i;
            }
        }
        return false;
    }

}
