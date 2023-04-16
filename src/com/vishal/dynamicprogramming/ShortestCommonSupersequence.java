package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class ShortestCommonSupersequence {

    public String shortestCommonSupersequence(String str1, String str2) {
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
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int row = len1;
        int col = len2;
        String result = "";
        while(row > 0 && col > 0){
            if(str1.charAt(row-1) == str2.charAt(col-1)){
                result = str1.charAt(row-1) + result;
                row--;col--;
            }else if(dp[row-1][col] > dp[row][col-1]){
                result = str1.charAt(row-1) + result;
                row--;
            }else{
                result = str2.charAt(col-1) + result;
                col--;
            }
        }
        while(row > 0){
            result = str1.charAt(row-1) + result;
            row--;
        }
        while(col > 0){
            result = str2.charAt(col-1) + result;
            col--;
        }
        return result;
    }

}
