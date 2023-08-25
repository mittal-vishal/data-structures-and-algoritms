package com.vishal.string;

import java.util.HashSet;

public class UniqueSubstringWithEqualFrequency {

    public int equalDigitFrequency(String s) {
        HashSet<String> uniques = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            int[] count = new int[10];
            for(int j=i; j < s.length(); j++){
                String substr = s.substring(i,j+1);
                count[s.charAt(j)-'0']++;
                if(isValid(count)){
                    uniques.add(substr);
                }
            }
        }
        return uniques.size();
    }

    private boolean isValid(int[] count){
        int prev = -1;
        for (int i = 0; i < 10; i++) {
            if (prev == -1 && count[i] != 0) {
                prev = count[i];
            } else if (count[i] != 0 && prev != count[i]){
                return false;
            }
        }

        return true;
    }

}
