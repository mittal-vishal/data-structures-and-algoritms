package com.vishal.windowsliding;

import java.util.*;

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

    public static List<Integer> findSubstring(String s, String[] words) {

        if(s == null || s.length() == 0 || words == null ||
                words.length == 0){
            return new ArrayList<>();
        }

        Map<String, Integer> wordsMap = new HashMap<>();
        for(String word: words){
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> indicesList = new ArrayList<>();
        int start = 0;
        int windowSize = words[0].length();

        while(start <= s.length() - (windowSize * words.length)){
            if(wordsMap.containsKey(s.substring(start,
                    start + windowSize))){
                if(isAllWordsExist(s, start, words.length * windowSize, windowSize,
                        wordsMap.size(), new HashMap(wordsMap))){
                    indicesList.add(start);
                }
            }
            start++;
        }

        return indicesList;
    }

    private static boolean isAllWordsExist(String s, int start, int n,
                                    int windowSize, int expectedCount, Map<String, Integer> wordsMap){
        if(expectedCount == 0){
            return true;
        }
        if(start <= n - windowSize + start){
            String word = s.substring(start, start + windowSize);
            if(wordsMap.containsKey(word) && wordsMap.get(word) != 0){
                wordsMap.put(word, wordsMap.get(word) - 1);
                if(wordsMap.get(word) == 0){
                    expectedCount--;
                }
                return isAllWordsExist(s, start + windowSize, n,
                        windowSize, expectedCount, wordsMap);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaaa";
        String[] words = {"aa","aa"};
        System.out.print(findSubstring(str, words));
    }
}
