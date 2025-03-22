package com.vishal.range;

public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] range = new int[length];
        for(int[] update: updates){
            int i = update[0];
            int j = update[1];
            int value = update[2];
            range[i] += value;
            if(j+1 < length){
                range[j+1] -= value;
            }
        }
        for(int i = 1; i < length; i++){
            range[i] += range[i-1];
        }
        return range;
    }

}
