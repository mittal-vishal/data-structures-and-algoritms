package com.vishal.google;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        //create map of indices, and pair, pair will consist of corresponding target string and next index of input string
        Map<Integer, Map.Entry<String,Integer>> replacements = new HashMap<>();
        int n = indices.length;
        for(int i = 0; i < n; i++){
            if(s.substring(indices[i]).startsWith(sources[i])){
                replacements.put(indices[i], new AbstractMap.SimpleEntry<>(targets[i], sources[i].length()-1));
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(replacements.containsKey(i)){
                Map.Entry<String,Integer> entry = replacements.get(i);
                result.append(entry.getKey());
                i += entry.getValue();
            }else{
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

}
