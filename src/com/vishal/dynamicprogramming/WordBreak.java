package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class WordBreak {

    HashMap<String, Boolean> wordMap = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)){
            return true;
        }else if(wordMap.containsKey(s)){
            return wordMap.get(s);
        }
        for(int i = 0; i < s.length(); i++){
            String left = s.substring(0, i + 1);
            String remaining = s.substring(i + 1);
            if(wordDict.contains(left) && wordBreak(remaining, wordDict)){
                wordMap.put(s, true);
                return true;
            }
        }
        wordMap.put(s, false);
        return false;
    }

}
