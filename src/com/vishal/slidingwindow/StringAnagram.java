package com.vishal.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagram {

    public static List<Integer> findStringAnagrams(String s, String p) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> charOccurMap = new HashMap<>();
        for(char ch: p.toCharArray()){
            charOccurMap.put(ch, charOccurMap.getOrDefault(ch, 0) + 1);
        }
        int desiredCount = charOccurMap.size();
        int actualCount = 0;
        int left = 0, right = 0;
        while(right < s.length()){
            //Expand the window until condition do not violates
            char currChar = s.charAt(right++);
            if(charOccurMap.containsKey(currChar)){
                charOccurMap.put(currChar, charOccurMap.get(currChar) - 1);
                if(charOccurMap.get(currChar) == 0){
                    actualCount++;
                }
            }
            //Shrink the window if condition violates
            if((right - left) > p.length()){
                char removeChar = s.charAt(left++);
                if(charOccurMap.containsKey(removeChar)){
                    if(charOccurMap.get(removeChar) == 0){
                        actualCount--;
                    }
                    charOccurMap.put(removeChar, charOccurMap.get(removeChar) + 1);
                }
            }
            if(actualCount == desiredCount){
                resultIndices.add(left);
            }
        }
        return resultIndices;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indicesList = new ArrayList<>();
        int[] patternArray = new int[26];
        int[] strArray = new int[26];
        for(char ch: p.toCharArray()){
            patternArray[ch - 'a']++;
        }
        int left = 0, right = 0;
        while(right < s.length()){
            strArray[s.charAt(right++) - 'a']++;
            if((right - left) > p.length())
                strArray[s.charAt(left++) - 'a']--;
            if((right - left) == p.length() &&
                    isEqual(strArray, patternArray))
                indicesList.add(left);
        }
        return indicesList;

    }

    private boolean isEqual(int[] strArray, int[] patternArray){
        for(int i = 0; i < 26; i++){
            if(strArray[i] != patternArray[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "cbaebabacd";
        String pattern = "abc";
        System.out.print(findStringAnagrams(str, pattern));
    }

}
