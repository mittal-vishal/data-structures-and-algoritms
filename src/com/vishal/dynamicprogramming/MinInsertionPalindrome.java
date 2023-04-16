package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MinInsertionPalindrome {

    public int minInsertions(String s) {
        int longestPalinSubsequence = longestPalindromeSubseq(s);
        return s.length() - longestPalinSubsequence;
    }

    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int len1 = s.length();
        int len2 = s2.length();
        int[][] dp = new int[len1][len2];
        for(int i = 0; i < len1; i++){
            Arrays.fill(dp[i], -1);
        }
        int result = lcs(s, s2, len1-1, len2-1, dp);
        return result;
    }

    private int lcs(String s1, String s2, int len1, int len2, int[][] dp){
        if(len1 < 0 || len2 < 0){
            return 0;
        }else if(s1.charAt(len1) == s2.charAt(len2)){
            return 1 + lcs(s1, s2, len1-1, len2-1, dp);
        }else if(dp[len1][len2] != -1){
            return dp[len1][len2];
        }else{
            dp[len1][len2] = Math.max(lcs(s1, s2, len1-1, len2, dp), lcs(s1, s2, len1, len2-1, dp));
            return dp[len1][len2];
        }
    }

}
