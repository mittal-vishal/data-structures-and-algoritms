package com.vishal.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSizeSubString {

    public static String findSubstring(String s, String t) {
        Map<Character,Integer> subOccurances = new HashMap<>();
        int left = 0;
        int right = 0;
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            subOccurances.put(ch, subOccurances.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> strOccurances = new HashMap<>();
        int maxLength = Integer.MAX_VALUE;
        String result = "";
        while(right < s.length()){
            //expand
            char ch = s.charAt(right++);
            strOccurances.put(ch, strOccurances.getOrDefault(ch, 0) + 1);
            //shrink
            while(isSubset(subOccurances, strOccurances) && left < right){
                char removeChar = s.charAt(left);
                if(maxLength > (right-left)){
                    maxLength = right-left;
                    result = s.substring(left, right);
                }
                if(strOccurances.get(removeChar) > 1){
                    strOccurances.put(removeChar, strOccurances.get(removeChar) - 1);
                }else{
                    strOccurances.remove(removeChar);
                }
                left++;
            }
        }
        return result;
    }

    private static boolean isSubset(Map<Character, Integer> subOccurances, Map<Character, Integer> strOccurances){
        for(Map.Entry<Character, Integer> entry: subOccurances.entrySet()){
            if(!strOccurances.containsKey(entry.getKey()) || strOccurances.get(entry.getKey()) < entry.getValue()){
                return false;
            }
        }
        return true;
    }

}
