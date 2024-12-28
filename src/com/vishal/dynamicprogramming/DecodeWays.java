package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public int numDecodings(String s) {
        int[] memo = new int[s.length()+1];
        Arrays.fill(memo, -1);
        return decodeWays(s, 0, memo);
    }

    private int decodeWays(String s, int i, int[] memo){
        if(i == s.length()){
            return 1;
        }else if(s.charAt(i) == '0'){
            return 0;
        }else if(memo[i] != -1){
            return memo[i];
        }
        int singleCharLength = decodeWays(s, i+1, memo);
        int doubleCharLength = 0;
        if(i+1 < s.length()){
            String twoCharStr = s.substring(i, i+2);
            if(Integer.parseInt(twoCharStr) > 9 && Integer.parseInt(twoCharStr) <= 26){
                doubleCharLength = decodeWays(s, i+2, memo);
            }
        }
        return memo[i] = singleCharLength + doubleCharLength;
    }

}
