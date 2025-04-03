package com.vishal.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public static boolean findPermutation(String str, String pattern) {
        if(pattern == null || str == null){
            return false;
        }else if(pattern == ""){
            return true;
        }
        Map<Character, Integer> charsOccurMap = new HashMap<>();
        for(char ch: pattern.toCharArray()){
            charsOccurMap.put(ch, charsOccurMap.getOrDefault(ch, 0) + 1);
        }
        int desiredCount = charsOccurMap.size();
        int actualCount = 0;
        int left = 0, right = 0;
        while(right < str.length()){
            //Expand the window
            char currChar = str.charAt(right++);
            if(charsOccurMap.containsKey(currChar)){
                charsOccurMap.put(currChar, charsOccurMap.get(currChar) - 1);
                if(charsOccurMap.get(currChar) == 0){
                    actualCount++;
                }
            }
            //Shrink the window
            if((right - left) > pattern.length()){
                char removeChar = str.charAt(left++);
                if(charsOccurMap.containsKey(removeChar)){
                    if(charsOccurMap.get(removeChar) == 0)
                        actualCount--;
                    charsOccurMap.put(removeChar, charsOccurMap.get(removeChar) + 1);
                }
            }
            if(actualCount == desiredCount)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "odicf";
        String pattern="dc";
        System.out.print(findPermutation(str, pattern));
    }

}
