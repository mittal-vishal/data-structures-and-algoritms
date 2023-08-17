package com.vishal.google;

import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<String,Integer> romanChars = new HashMap<>();
        romanChars.put("I", 1);
        romanChars.put("V", 5);
        romanChars.put("X", 10);
        romanChars.put("L", 50);
        romanChars.put("C", 100);
        romanChars.put("D", 500);
        romanChars.put("M", 1000);
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            String oneChar = s.substring(i, i+1);
            int oneCharVal = 0;
            if(romanChars.containsKey(oneChar)){
                oneCharVal = romanChars.get(oneChar);
            }
            int twoCharVal = 0;
            if(i+2 <= s.length()){
                String twoChar = s.substring(i+1, i+2);
                if(romanChars.containsKey(twoChar)){
                    twoCharVal = romanChars.get(twoChar);
                }
            }
            if(twoCharVal > oneCharVal){
                result += twoCharVal - oneCharVal;
                i++;
            }else{
                result += oneCharVal;
            }
        }
        return result;
    }

}
