package com.vishal.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinLengthSubString {

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.print(findSubstring(s, t));
    }

    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> charsMap = new HashMap<>();
        for(char ch : pattern.toCharArray()){
            charsMap.put(ch, charsMap.getOrDefault(ch, 0) + 1);
        }
        int expectedCount = charsMap.size();
        int actualCount = 0;
        int left = 0, right = 0;
        String returnStr = "";
        int minLength = Integer.MAX_VALUE;

        while(right < str.length()){
            //Expand the window until condition satisfies
            char currentChar = str.charAt(right++);
            if(charsMap.containsKey(currentChar)) {
                charsMap.put(currentChar, charsMap.get(currentChar) - 1);
                if (charsMap.get(currentChar) == 0) {
                    actualCount++;
                }
            }
            //Shrink the window until condition do not violates and update the answer
            while(left < right && actualCount == expectedCount){
                if((right - left) < minLength){
                    returnStr = str.substring(left, right);
                    minLength = right - left;
                }
                char removedChar = str.charAt(left++);
                if(charsMap.containsKey(removedChar)){
                    if(charsMap.get(removedChar) == 0)
                        actualCount--;
                    charsMap.put(removedChar, charsMap.get(removedChar) + 1);
                }
            }
        }

        return returnStr;
    }

    public static String minWindow(String s, String t) {

        if(s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();

        int desiredCount = t.length();
        int currentCount = 0;

        int left = 0, right = 0;
        String res = "";

        while(right < s.length()){
            //Expand until condition met
            while(right < s.length() && currentCount < desiredCount){
                char ch = s.charAt(right);
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                if(sMap.getOrDefault(ch, 0) <= tMap.getOrDefault(ch, 0)){
                    currentCount++;
                }
                right++;
            }
            //Contract and optimize for min length
            while(left < right && desiredCount == currentCount){
                String temp = s.substring(left, right);
                if(res == "" || temp.length() < res.length()){
                    res = temp;
                }
                char ch = s.charAt(left);
                if(sMap.get(ch) == 1){
                    sMap.remove(ch);
                }else{
                    sMap.put(ch, sMap.get(ch) - 1);
                }
                if(sMap.getOrDefault(ch, 0) < tMap.getOrDefault(ch, 0)){
                    currentCount--;
                }
                left++;
            }
        }
        return res;
    }

}
