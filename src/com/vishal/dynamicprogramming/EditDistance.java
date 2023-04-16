package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        int[][] dp = new int[i][j];
        for(int k = 0; k < i; k++){
            Arrays.fill(dp[k], -1);
        }
        return minDist(word1, word2, i-1, j-1, dp);
    }

    private int minDist(String word1, String word2, int i, int j, int[][] dp){
        if(i < 0){
            return j+1;
        }else if(j < 0){
            return i+1;
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }else if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = minDist(word1, word2, i-1, j-1, dp);
        }else{
            int insertion = 1 + minDist(word1, word2, i, j-1, dp);
            int deletion = 1 + minDist(word1, word2, i-1, j, dp);
            int replace = 1 + minDist(word1, word2, i-1, j-1, dp);
            return dp[i][j] = Math.min(insertion, Math.min(deletion, replace));
        }
    }

    public int minDistanceTabulation(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= n; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insertion = 1 + dp[i][j-1];
                    int deletion = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insertion, Math.min(deletion, replace));
                }
            }
        }
        return dp[m][n];
    }

}
