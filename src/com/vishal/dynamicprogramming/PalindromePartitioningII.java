package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class PalindromePartitioningII {

    private int INT_MAX = (int)1e8;

    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return minCut(0, s, dp) - 1;
    }

    private int minCut(int i, String s, int[] dp){
        if(i == s.length()){
            return 0;
        }else if(dp[i] != -1){
            return dp[i];
        }
        int minimum = INT_MAX;
        for(int j = i+1; j <= s.length(); j++){
            String substr = s.substring(i, j);
            if(isPalin(substr)){
                int cost =  1 + minCut(j, s, dp);
                minimum = Math.min(minimum, cost);
            }
        }
        return dp[i] = minimum;
    }

    private boolean isPalin(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

}
