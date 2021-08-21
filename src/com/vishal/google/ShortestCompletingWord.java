package com.vishal.google;

import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> charOccurMap = new HashMap<>();
        for(char ch: licensePlate.toCharArray()){
            ch = Character.toLowerCase(ch);
            if(ch >= 97 && ch <= 122){
                charOccurMap.put(ch, charOccurMap.getOrDefault(ch, 0) + 1);
            }
        }
        String resultant = "";
        int max = Integer.MAX_VALUE;
        int minLen = 0;
        for(String word: words){
            HashMap<Character, Integer> wordMap = new HashMap<>(charOccurMap);
            for(char ch: word.toCharArray()){
                if(wordMap.containsKey(ch) && wordMap.get(ch) > 0){
                    wordMap.put(ch, wordMap.get(ch) - 1);
                }
            }
            int dist = 0;
            for(Map.Entry<Character, Integer> entry: wordMap.entrySet()){
                dist += entry.getValue();
            }
            if(dist < max){
                max = dist;
                resultant = word;
                minLen = word.length();
            }else if(dist == max && word.length() < minLen){
                minLen = word.length();
                resultant = word;
            }
        }
        return resultant;
    }

}
