package com.vishal.microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinDelToMakeCharFreqUnique {

    public int minDeletions(String s) {
        HashMap<Character, Integer> occurMap = new HashMap<>();
        for(char ch: s.toCharArray()){
            occurMap.put(ch, occurMap.getOrDefault(ch, 0) + 1);
        }
        int deletions = 0;
        Set<Integer> occurSet = new HashSet<>();
        for(Map.Entry<Character, Integer> entry: occurMap.entrySet()){
            int currOccur = entry.getValue();
            while(occurSet.contains(currOccur)){
                if(currOccur == 0){
                    break;
                }
                currOccur--;
                deletions++;
            }
            occurSet.add(currOccur);
        }
        return deletions;
    }

}
