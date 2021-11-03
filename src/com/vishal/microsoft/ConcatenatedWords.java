package com.vishal.microsoft;

import java.util.*;

public class ConcatenatedWords {

    private HashMap<String, Boolean> cache;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        cache = new HashMap<>();
        Set<String> dictionarySet = new HashSet<>();
        List<String> finalList = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            dictionarySet.add(words[i]);
        }

        for(int i = 0; i < words.length; i++){
            if(isBreakDownPossible(words[i], dictionarySet)){
                finalList.add(words[i]);
            }
        }

        return finalList;
    }

    private boolean isBreakDownPossible(String word, Set<String> dictionarySet){
        if(cache.containsKey(word)){
            return cache.get(word);
        }
        for(int i = 1; i < word.length(); i++){
            String left = word.substring(0, i);
            String right = word.substring(i);
            if(dictionarySet.contains(left)){
                if(dictionarySet.contains(right) || isBreakDownPossible(right, dictionarySet)){
                    cache.put(word, true);
                    return true;
                }
            }
        }
        cache.put(word, false);
        return false;
    }

}
