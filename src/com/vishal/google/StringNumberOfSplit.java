package com.vishal.google;

import java.util.HashMap;
import java.util.Map;

public class StringNumberOfSplit {

    public int numSplits(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }

        Map<Character, Integer> firstSplitMap = new HashMap<>();
        Map<Character, Integer> secondSplitMap = new HashMap<>();

        firstSplitMap.put(s.charAt(0), 1);

        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            secondSplitMap.put(ch, secondSplitMap.getOrDefault(ch, 0) + 1);
        }

        int split = 1;
        int splitCount = 0;
        if(firstSplitMap.size() == secondSplitMap.size()){
            splitCount++;
        }
        while(split < s.length() - 1 && firstSplitMap.size() <= secondSplitMap.size()){
            char currentSplitChar = s.charAt(split);
            firstSplitMap.put(currentSplitChar, firstSplitMap.getOrDefault(currentSplitChar, 0) + 1);
            if(secondSplitMap.get(currentSplitChar) > 1){
                secondSplitMap.put(currentSplitChar, secondSplitMap.get(currentSplitChar) - 1);
            }else{
                secondSplitMap.remove(currentSplitChar);
            }
            if(firstSplitMap.size() == secondSplitMap.size()){
                splitCount++;
            }
            split++;
        }
        return splitCount;
    }

}
