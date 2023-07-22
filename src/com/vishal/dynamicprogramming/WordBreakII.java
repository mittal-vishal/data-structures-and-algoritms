package com.vishal.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {

    private HashSet<String> dictionary;

    public List<String> wordBreak(String s, List<String> wordDict) {
        dictionary = new HashSet<>();
        for(String word: wordDict){
            dictionary.add(word);
        }
        List<String> result = new ArrayList<>();
        wordBreak(s, 0, "", result);
        return result;
    }

    private void wordBreak(String s, int index, String curr, List<String> result){
        if(index == s.length()){
            result.add(curr.substring(0, curr.length()-1));
            return;
        }
        for(int i = index+1; i <= s.length(); i++){
            String left = s.substring(index, i);
            if(dictionary.contains(left)){
                wordBreak(s, i, curr+left+" ", result);
            }
        }
    }

}
