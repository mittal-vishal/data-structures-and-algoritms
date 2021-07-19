package com.vishal.google;

public class MinDominoRotationForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minRotations = Math.min(
                numSwap(tops[0], tops, bottoms), numSwap(bottoms[0], tops, bottoms));
        minRotations = Math.min(minRotations, numSwap(tops[0], bottoms, tops));
        minRotations = Math.min(minRotations, numSwap(bottoms[0], bottoms, tops));
        return minRotations != Integer.MAX_VALUE ? minRotations : -1;
    }

    private int numSwap(int target, int[] primary, int[] secondary){
        int rotations = 0;
        for(int i = 0; i < primary.length; i++){
            if(primary[i] != target && secondary[i] != target){
                return Integer.MAX_VALUE;
            }else if(primary[i] != target && secondary[i] == target){
                rotations++;
            }
        }
        return rotations;
    }

}
