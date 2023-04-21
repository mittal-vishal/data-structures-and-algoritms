package com.vishal.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat","cats","and","sand","dog");
        WordBreakII wordBreakII = new WordBreakII();
        System.out.println(wordBreakII.wordBreak(s, dict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        return wordBreak(s, dict);
    }
    private List<String> wordBreak(String s, HashSet<String> dict){
        List<String> results = new ArrayList<>();
        if(dict.contains(s)){
            results.add(s);
        }
        for(int i = 1; i <= s.length(); i++){
            String left = s.substring(0, i);
            if(dict.contains(left)){
                String remaining = s.substring(i);
                List<String> subList = wordBreak(remaining, dict);
                for(String substr: subList){
                    results.add(left + " " + substr);
                }
            }
        }
        return results;
    }

}
