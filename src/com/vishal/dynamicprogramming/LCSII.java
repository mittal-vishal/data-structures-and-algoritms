package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LCSII {

    public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
        int len1 = a.size();
        int len2 = b.size();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i <= len1; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < len2; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(a.get(i-1) == b.get(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int row = len1;
        int col = len2;
        LinkedList<Integer> result = new LinkedList<>();
        while(row > 0 && col > 0){
            if(a.get(row-1) == b.get(col-1)){
                result.addFirst(a.get(row-1));
                row--;col--;
            }else{
                if(dp[row][col-1] > dp[row-1][col]){
                    col--;
                }else{
                    row--;
                }
            }
        }
        return result;
    }
}
