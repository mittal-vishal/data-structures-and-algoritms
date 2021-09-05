package com.vishal.search;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    public int maxDistance(int[] position, int m) {
        int minF = 1;
        Arrays.sort(position);
        int maxF = position[position.length - 1];
        int max = 1;
        while(minF <= maxF){
            int mid = minF + (maxF - minF) / 2;
            if(isPossible(position, m, mid)){
                max = Math.max(max, mid);
                minF = mid + 1;
            }else{
                maxF = mid - 1;
            }
        }
        return max;
    }

    private boolean isPossible(int[] position, int m, int dist){
        int prevStall = 0;
        int stall = 1;
        for(int i = 1; i < m; i++){
            while(position[stall] - position[prevStall] < dist){
                stall++;
                if(stall == position.length){
                    return false;
                }
            }
            prevStall = stall;
        }
        return true;
    }

}
