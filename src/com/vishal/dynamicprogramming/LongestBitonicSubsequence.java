package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp1[i] = Math.max(dp1[i], dp1[j]+1);
                }
            }
        }
        int maxLDS = 1;
        for(int i = n-2; i >= 0; i--){
            for(int j = n-1; i < j; j--){
                if(nums[i] > nums[j]){
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                }
            }
        }
        int maxMountain = 0;
        for(int i = 0; i < n; i++){
            maxMountain = Math.max(maxMountain, dp1[i] + dp2[i] - 1);
        }
        return maxMountain;
    }

}
