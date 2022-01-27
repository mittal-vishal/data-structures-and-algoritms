package com.vishal.microsoft;

public class LongestPalinSubsequence {

    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s1).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        inititalizeLCS(dp, s1, s2);
        String lcs = getLCS(dp, s1);
        System.out.print(lcs);
        return lcs.length();
    }

    private void inititalizeLCS(int[][] dp, String s1, String s2){
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s1.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }

    private String getLCS(int[][] dp, String s){
        StringBuilder lcs = new StringBuilder();
        int i = dp.length - 1;
        int j = dp.length - 1;
        while(i != 0 && j != 0){
            if(dp[i-1][j] == dp[i][j-1] && dp[i][j-1] == dp[i-1][j-1]
                    && dp[i][j] > dp[i-1][j-1]){
                lcs.append(s.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        return lcs.toString();
    }

}
