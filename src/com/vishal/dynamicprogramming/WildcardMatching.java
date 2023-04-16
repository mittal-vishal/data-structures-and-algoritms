package com.vishal.dynamicprogramming;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] dp = new Boolean[m][n];
        return isMatch(s, p, m-1, n-1, dp);
    }

    private boolean isMatch(String s, String p, int m, int n, Boolean[][] dp){
        if(m < 0 && n < 0){
            return true;
        }else if(m >= 0 && n < 0){
            return false;
        }else if(m < 0 && n >= 0){
            for(int i = 0; i <= n; i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }else if(dp[m][n] != null){
            return dp[m][n];
        }else if(s.charAt(m) == p.charAt(n) || (p.charAt(n) == '?')){
            return dp[m][n] = isMatch(s, p, m-1, n-1, dp);
        }else if(p.charAt(n) == '*'){
            return dp[m][n] = isMatch(s, p, m, n-1, dp) || isMatch(s, p, m-1, n, dp);
        }else{
            return false;
        }
    }

    public boolean isMatchTabulation(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] dp = new Boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++){
            dp[i][0] = false;
        }
        for(int j = 1; j <= n; j++){
            boolean isAllSpecialChar = true;
            for(int k = 1; k <= j; k++){
                if(p.charAt(k-1) != '*'){
                    isAllSpecialChar = false;
                    break;
                }
            }
            dp[0][j] = isAllSpecialChar;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || (p.charAt(j-1) == '?')){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

}
