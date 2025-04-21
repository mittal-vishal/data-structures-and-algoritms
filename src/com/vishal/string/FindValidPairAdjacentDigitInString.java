package com.vishal.string;

public class FindValidPairAdjacentDigitInString {

    public String findValidPair(String s) {
        int[] occurance = new int[10];
        for(int i = 0; i < s.length(); i++){
            occurance[s.charAt(i)-'0']++;
        }
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) != s.charAt(i+1) && occurance[s.charAt(i)-'0'] == s.charAt(i)-'0' && occurance[s.charAt(i+1)-'0'] == s.charAt(i+1)-'0'){
                return s.substring(i, i+2);
            }
        }
        return "";
    }

}
