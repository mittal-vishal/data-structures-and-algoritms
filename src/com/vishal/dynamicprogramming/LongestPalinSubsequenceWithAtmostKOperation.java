package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class LongestPalinSubsequenceWithAtmostKOperation {

    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();
        int[][][] dp = new int[n][n][k+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getLongestPalinSubsequence(s, 0, s.length()-1, k, dp);
    }

    private int getLongestPalinSubsequence(String s, int i, int j, int k, int[][][] dp){
        if(i == j){
            return 1;
        }else if(i > j){
            return 0;
        }else if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }
        int skipLeftChar = getLongestPalinSubsequence(s, i+1, j, k, dp);
        int skipRightChar = getLongestPalinSubsequence(s, i, j-1, k, dp);
        int matchWithOperation = 0;
        int cost = Math.min(Math.abs(s.charAt(i)-s.charAt(j)), 26 - Math.abs(s.charAt(j) - s.charAt(i)));
        if(cost <= k){
            matchWithOperation = 2 + getLongestPalinSubsequence(s, i+1, j-1, k-cost, dp);
        }
        return dp[i][j][k] = Math.max(skipLeftChar, Math.max(skipRightChar, matchWithOperation));
    }

}
