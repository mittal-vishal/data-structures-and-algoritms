package com.vishal.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        HashMap<String, List<Integer>> wordsOccurance = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            wordsOccurance.putIfAbsent(wordsDict[i], new ArrayList<>());
            wordsOccurance.get(wordsDict[i]).add(i);
        }
        List<Integer> occuranceFrom = wordsOccurance.get(word1);
        List<Integer> occuranceTo = wordsOccurance.get(word2);
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < occuranceFrom.size(); i++){
            for(int j = 0; j < occuranceTo.size(); j++){
                shortest = Math.min(shortest, Math.abs(occuranceFrom.get(i)-occuranceTo.get(j)));
            }
        }
        return shortest;
    }

}
