package com.vishal.search;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int beg = 1;
        int end = position[n-1] - position[0];
        int result = 0;
        while(beg <= end){
            int guess = beg + (end - beg)/2;
            if(isPossible(position, n , m , guess)){
                result = Math.max(result, guess);
                beg = guess + 1;
            }else{
                end = guess - 1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] position, int n, int m, int guess){
        int i = 0;
        int j = 1;
        m--;
        while(j < n){
            if(position[j] - position[i] >= guess){
                i = j;
                m--;
            }
            j++;
        }
        if(m > 0){
            return false;
        }else{
            return true;
        }
    }

}
