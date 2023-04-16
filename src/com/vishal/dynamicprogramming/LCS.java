package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCS {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        for(int i = 0; i < len1; i++){
            Arrays.fill(dp[i], -1);
        }
        return lcs(text1, text2, len1-1, len2-1, dp);
    }

    private int lcs(String text1, String text2, int len1, int len2, int[][] dp){
        if(len1 < 0 || len2 < 0){
            return 0;
        }else if(dp[len1][len2] != -1){
            return dp[len1][len2];
        }else if(text1.charAt(len1) == text2.charAt(len2)){
            return 1 + lcs(text1, text2, len1-1, len2-1, dp);
        }else{
            dp[len1][len2] = Math.max(lcs(text1, text2, len1-1, len2, dp), lcs(text1, text2, len1, len2-1, dp));
            return dp[len1][len2];
        }
    }

    public int longestCommonSubsequenceTabulation(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i <= len1; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= len2; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

}
