package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLIS = 1;
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(compare(words[i], words[j]) && dp[j]+1 > dp[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return maxLIS;
    }

    private boolean compare(String s, String t){
        if(s.length() < t.length()){
            return false;
        }
        int i = 0;
        int j = 0;
        int distance = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;j++;
            }else{
                i++;
                distance++;
            }
        }
        i = s.length()-i;
        j = t.length()-j;
        distance += (i+j);
        if(distance == 1){
            return true;
        }else{
            return false;
        }
    }

}
