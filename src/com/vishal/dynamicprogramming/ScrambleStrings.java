package com.vishal.dynamicprogramming;

import java.util.HashMap;

public class ScrambleStrings {

    public boolean isScramble(String s1, String s2) {
        HashMap<String,Boolean> memo = new HashMap<>();
        return scramble(s1, s2, memo);
    }

    private boolean scramble(String s1, String s2, HashMap<String,Boolean> memo){
        int n = s1.length();
        if(n == 1){
            return s1.equals(s2);
        }
        String key = s1+","+s2;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        for(int i = 1; i < n; i++){
            if(scramble(s1.substring(0,i), s2.substring(0,i), memo) && scramble(s1.substring(i), s2.substring(i), memo)
                    || scramble(s1.substring(0,i), s2.substring(n-i), memo) && scramble(s1.substring(i), s2.substring(0,n-i), memo)){
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }

}
