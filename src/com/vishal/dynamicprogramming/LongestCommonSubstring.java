package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubstring {

    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
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
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

}
