package com.vishal.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class MinLengthSubString {

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        System.out.print(minWindow(s, t));
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
