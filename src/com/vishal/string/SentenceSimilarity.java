package com.vishal.string;

import java.util.*;

public class SentenceSimilarity {

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length){
            return false;
        }
        Map<String, Set<String>> wordsMap = new HashMap<>();
        for(List<String> words: similarPairs){
            wordsMap.putIfAbsent(words.get(0), new HashSet<>());
            wordsMap.putIfAbsent(words.get(1), new HashSet<>());
            wordsMap.get(words.get(0)).add(words.get(1));
            wordsMap.get(words.get(1)).add(words.get(0));
        }
        for(int i = 0; i < sentence1.length; i++){
            String currWord = sentence1[i];
            if(currWord.equals(sentence2[i])){
                continue;
            }
            if(!wordsMap.containsKey(currWord) ||
                    !wordsMap.get(currWord).contains(sentence2[i])){
                return false;
            }
        }
        return true;
    }

}
