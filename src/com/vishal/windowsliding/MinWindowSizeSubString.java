package com.vishal.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSizeSubString {

    public String minWindow(String s, String t) {
        HashMap<Character,Integer> sOccurance = new HashMap<>();
        HashMap<Character,Integer> tOccurance = new HashMap<>();
        for(char ch: t.toCharArray()){
            tOccurance.put(ch, tOccurance.getOrDefault(ch,0) + 1);
        }
        int left = 0;
        int right = 0;
        String result = "";
        int minLength = s.length() + 1;
        while(right < s.length()){
            //expand until cond doesn't met
            char ch = s.charAt(right++);
            sOccurance.put(ch, sOccurance.getOrDefault(ch,0) + 1);
            //keep shrinking until condition don't violate
            while(left < right && isSubSetContains(sOccurance, tOccurance)){
                if((right-left) < minLength){
                    minLength = right-left;
                    result = s.substring(left, right);
                }
                char leftChar = s.charAt(left++);
                if(sOccurance.get(leftChar) > 1){
                    sOccurance.put(leftChar, sOccurance.get(leftChar)-1);
                }else{
                    sOccurance.remove(leftChar);
                }
            }
        }
        return result;
    }

    private boolean isSubSetContains(HashMap<Character,Integer> sOccurance, HashMap<Character,Integer> tOccurance){
        for(Map.Entry<Character,Integer> entry: tOccurance.entrySet()){
            Character key = entry.getKey();
            if(!sOccurance.containsKey(key) || sOccurance.get(key) < tOccurance.get(key)){
                return false;
            }
        }
        return true;
    }

}
