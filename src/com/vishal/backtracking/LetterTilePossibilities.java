package com.vishal.backtracking;

import java.util.HashMap;
import java.util.Map;

public class LetterTilePossibilities {

    private HashMap<Character,Integer> occurance;

    public int numTilePossibilities(String tiles) {
        occurance = new HashMap<>();
        for(char ch: tiles.toCharArray()){
            occurance.put(ch, occurance.getOrDefault(ch, 0) + 1);
        }
        return backtrack();
    }

    private int backtrack(){
        int result = 0;
        for(Map.Entry<Character,Integer> entry: occurance.entrySet()){
            if(entry.getValue() > 0){
                occurance.put(entry.getKey(), entry.getValue()-1);
                result += 1;
                result += backtrack();
                occurance.put(entry.getKey(), entry.getValue()+1);
            }
        }
        return result;
    }

}
