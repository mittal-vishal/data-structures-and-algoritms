package com.vishal.linkedin;

import java.util.HashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        //base case
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Character> sToTMap = new HashMap<>();
        HashMap<Character,Character> tToSMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(sToTMap.containsKey(sChar) && sToTMap.get(sChar) != tChar || tToSMap.containsKey(tChar) && tToSMap.get(tChar) != sChar){
                return false;
            }
            sToTMap.put(sChar, tChar);
            tToSMap.put(tChar, sChar);
        }
        return true;
    }

}
