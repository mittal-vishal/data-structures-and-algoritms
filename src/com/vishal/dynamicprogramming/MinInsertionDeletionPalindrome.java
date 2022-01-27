package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MinInsertionDeletionPalindrome {

    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return getMinInsertion(s, 0, s.length() - 1, dp);
    }

    private int getMinInsertion(String s, int beg, int end, int[][] dp){
        if(beg >= end){
            return 0;
        }else if(dp[beg][end] != -1){
            return dp[beg][end];
        }else if(s.charAt(beg) == s.charAt(end)){
            return getMinInsertion(s, beg + 1, end - 1, dp);
        }else{
            dp[beg][end] = 1 + Math.min(getMinInsertion(s, beg, end - 1, dp),
                    getMinInsertion(s, beg + 1, end, dp));
            return dp[beg][end];
        }
    }

}
