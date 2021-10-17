package com.vishal.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    public String reverseVowels(String s) {
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.addAll(Arrays.asList('a','A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

        int i = 0;
        int j = s.length() - 1;
        char[] sArray = s.toCharArray();
        while(i < j){
            while(i < j && !vowelSet.contains(s.charAt(i))){
                i++;
            }
            while(i < j && !vowelSet.contains(s.charAt(j))){
                j--;
            }
            char temp = sArray[i];
            sArray[i] = sArray[j];
            sArray[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(sArray);
    }

}
