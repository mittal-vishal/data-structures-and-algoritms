package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        HashMap<String,Boolean> memo = new HashMap<>();
        return canBreak(s, dictionary, memo);
    }

    private boolean canBreak(String s, Set<String> dictionary, HashMap<String,Boolean> memo){
        if(s.length() == 0){
            return true;
        }else if(memo.containsKey(s)){
            return memo.get(s);
        }
        for(int i = 1; i <= s.length(); i++){
            String left = s.substring(0, i);
            String remaining = s.substring(i, s.length());
            if(dictionary.contains(left) && canBreak(remaining, dictionary, memo)){
                memo.put(s, true);
                return memo.get(s);
            }
        }
        memo.put(s, false);
        return memo.get(s);
    }

}
