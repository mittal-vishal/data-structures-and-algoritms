package com.vishal.windowsliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<>();
        int wordsCount = words.length;
        int wordLength = words[0].length();
        Map<String, Integer> wordsFreqMap = new HashMap<>();
        for(String word: words){
            wordsFreqMap.put(word, wordsFreqMap.getOrDefault(word, 0) + 1);
        }
        for(int i = 0; i <= str.length() - (wordsCount * wordLength); i++){
            Map<String, Integer> wordsSeenMap = new HashMap<>();
            for(int j = 0; j < wordsCount; j++){
                int newWordIndex = i + (j * wordLength);
                String currentWord = str.substring(newWordIndex, newWordIndex + wordLength);
                if(!wordsFreqMap.containsKey(currentWord)){
                    break;
                }else{
                    wordsSeenMap.put(currentWord, wordsSeenMap.getOrDefault(currentWord, 0) + 1);
                }
                if(wordsSeenMap.get(currentWord) > wordsFreqMap.get(currentWord)){
                    break;
                }
                if(j + 1 == wordsCount){
                    resultIndices.add(i);
                }
            }
        }
        return resultIndices;
    }
}
