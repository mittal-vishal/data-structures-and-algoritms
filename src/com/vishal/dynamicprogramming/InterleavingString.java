package com.vishal.dynamicprogramming;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        Boolean[][] dp = new Boolean[m][n];
        return match(s1, 0, s2, 0, s3, 0, dp);
    }

    private boolean match(String s1, int i, String s2, int j, String s3, int k, Boolean[][] dp){
        if(i == s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }else if(j == s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }else if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean result = false;
        if(s1.charAt(i) == s3.charAt(k) && match(s1, i+1, s2, j, s3, k+1, dp)){
            result = true;
        }
        if(s2.charAt(j) == s3.charAt(k) && match(s1, i, s2, j+1, s3, k+1, dp)){
            result = true;
        }
        return dp[i][j] = result;
    }

}
