package com.vishal.subarray;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] sArray = new int[26];
        int[] pArray = new int[26];

        for(char ch: p.toCharArray()){
            pArray[ch-'a']++;
        }

        int right = 0, left = 0;

        while(right < s.length()){

            sArray[s.charAt(right) - 'a']++;
            right++;

            if((right - left) > p.length()){
                sArray[s.charAt(left) - 'a']--;
                left++;
            }

            if(isSame(sArray, pArray))
                result.add(left);

        }

        return result;

    }

    private boolean isSame(int[] s, int[] p){
        for(int i = 0; i < 26; i++){
            if(s[i] != p[i]){
                return false;
            }
        }
        return true;
    }

}
