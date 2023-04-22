package com.vishal.windowsliding;

public class NumberOfSubstringContainingThreeChars {

    public int numberOfSubstrings(String s) {
        int[] charCount = new int[3];
        int left = 0;
        int right = 0;
        int n = s.length();
        int result = 0;
        while(right < n){
            //expand the window
            char currChar = s.charAt(right++);
            charCount[currChar-'a']++;
            //shrink
            while(charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0){
                result += (n-right+1);
                char leftChar = s.charAt(left++);
                charCount[leftChar-'a']--;
            }
        }
        return result;
    }

}
