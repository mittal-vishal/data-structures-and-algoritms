package com.vishal.range;

public class ZeroArrayTransformationI {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] range = new int[nums.length];
        int n = nums.length;
        for(int[] query: queries){
            int i = query[0];
            int j = query[1];
            range[i]++;
            if(j+1 < n){
                range[j+1]--;
            }
        }
        for(int i = 1; i < n; i++){
            range[i] += range[i-1];
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > range[i]){
                return false;
            }
        }
        return true;
    }

}
