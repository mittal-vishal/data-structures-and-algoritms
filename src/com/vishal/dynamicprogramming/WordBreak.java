package com.vishal.dynamicprogramming;

import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return canBreak(s, 0, dict, dp);
    }

    private boolean canBreak(String s, int index, HashSet<String> dict, Boolean[] dp){
        if(index == s.length()){
            return true;
        }else if(dp[index] != null){
            return dp[index];
        }
        for(int j = index+1; j <= s.length(); j++){
            String left = s.substring(index, j);
            if(dict.contains(left) && canBreak(s, j, dict, dp)){
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }

}
