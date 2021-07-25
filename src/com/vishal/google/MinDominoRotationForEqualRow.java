package com.vishal.google;

public class MinDominoRotationForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || bottoms == null || tops.length == 0 || bottoms.length == 0){
            return -1;
        }
        int rotations = Integer.MAX_VALUE;
        rotations = Math.min(countSwaps(tops[0], tops, bottoms),
                countSwaps(bottoms[0], tops, bottoms));
        rotations = Math.min(rotations,
                Math.min(countSwaps(tops[0], bottoms, tops),
                        countSwaps(bottoms[0], bottoms, tops)));
        return rotations != Integer.MAX_VALUE ? rotations: -1;
    }

    private int countSwaps(int target, int[] a, int[] b){
        int swaps = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == target){
                continue;
            }else if(b[i] == target){
                swaps++;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        return swaps;
    }

}
