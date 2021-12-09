package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    private Map<Integer, Integer> memo;

    public int numDecodings(String s) {
        memo = new HashMap<>();
        return decode(s, 0);
    }

    private int decode(String str, int idx){
        if(memo.containsKey(idx)){
            return memo.get(idx);
        }
        if(idx == str.length()){
            return 1;
        }
        if(str.charAt(idx) == '0'){
            return 0;
        }
        if(idx == str.length()-1){
            return 1;
        }
        int ans = decode(str, idx + 1);
        String decodeStr = str.substring(idx, idx + 2);
        if(Integer.parseInt(decodeStr) <= 26){
            ans += decode(str, idx + 2);
        }
        memo.put(idx, ans);
        return memo.get(idx);
    }

}
