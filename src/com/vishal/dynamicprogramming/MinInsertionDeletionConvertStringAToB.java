package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MinInsertionDeletionConvertStringAToB {

    public int minOperations(String str1, String str2)
    {
        int n =  str1.length();
        int m = str2.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int lcsLength = lcs(str1, str2, n-1, m-1, dp);
        return (n+m)-(2*lcsLength);
    }

    private int lcs(String str1, String str2, int len1, int len2, int[][] dp){
        if(len1 < 0 || len2 < 0){
            return 0;
        }else if(dp[len1][len2] != -1){
            return dp[len1][len2];
        }else if(str1.charAt(len1) == str2.charAt(len2)){
            return 1 + lcs(str1, str2, len1-1, len2-1, dp);
        }else{
            return dp[len1][len2] = Math.max(lcs(str1, str2, len1-1, len2, dp), lcs(str1, str2, len1, len2-1, dp));
        }
    }

}
