package com.vishal.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistanceII {

    private HashMap<String, List<Integer>> wordOccurances;

    public ShortestWordDistanceII(String[] wordsDict) {
        wordOccurances = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            wordOccurances.putIfAbsent(wordsDict[i], new ArrayList<>());
            wordOccurances.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> occurancesA = wordOccurances.get(word1);
        List<Integer> occurancesB = wordOccurances.get(word2);
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < occurancesA.size(); i++){
            for(int j = 0; j < occurancesB.size(); j++){
                shortest = Math.min(shortest, Math.abs(occurancesA.get(i) - occurancesB.get(j)));
            }
        }
        return shortest;
    }

}
