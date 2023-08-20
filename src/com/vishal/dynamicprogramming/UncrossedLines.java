package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxUncrossedLines(nums1, nums2, 0, 0, dp);
    }

    private int maxUncrossedLines(int[] nums1, int[] nums2, int i, int j, int[][] dp){
        if(i == nums1.length || j == nums2.length){
            return 0;
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }else if(nums1[i] == nums2[j]){
            return dp[i][j] = 1 + maxUncrossedLines(nums1, nums2, i+1, j+1, dp);
        }else{
            return dp[i][j] = Math.max(maxUncrossedLines(nums1, nums2, i+1, j, dp), maxUncrossedLines(nums1, nums2, i, j+1, dp));
        }
    }

}
