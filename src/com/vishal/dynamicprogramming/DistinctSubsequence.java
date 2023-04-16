package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class DistinctSubsequence {

    public int numDistinct(String s, String t) {
        int i = s.length();
        int j = t.length();
        int[][] dp = new int[i][j];
        for(int k = 0; k < i; k++){
            Arrays.fill(dp[k], -1);
        }
        return countWays(s, t, i-1, j-1, dp);
    }

    private int countWays(String s, String t, int i, int j, int[][] dp){
        if(j < 0){
            return 1;
        }else if(i < 0){
            return 0;
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }else if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = countWays(s, t, i-1, j-1, dp) + countWays(s, t, i-1, j, dp);
        }else{
            return dp[i][j] = countWays(s, t, i-1, j, dp);
        }
    }

    public int numDistinctTabulation(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j <= n; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

}
