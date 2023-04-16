package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decodeWays(s, 0, dp);
    }

    private int decodeWays(String s, int index, int[] dp){
        if(index == s.length()){
            return 1;
        }else if(s.charAt(index) == '0'){
            return 0;
        }else if(dp[index] != -1){
            return dp[index];
        }
        int singleDigit = decodeWays(s, index+1, dp);
        int twoDigit = 0;
        if(index+1 < s.length()){
            String twoDigitStr = s.substring(index, index+2);
            if(Integer.valueOf(twoDigitStr) >= 0 && Integer.valueOf(twoDigitStr) <= 26){
                twoDigit = decodeWays(s, index+2, dp);
            }
        }
        return dp[index] = singleDigit + twoDigit;
    }

}
