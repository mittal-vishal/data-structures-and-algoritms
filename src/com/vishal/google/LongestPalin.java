package com.vishal.google;

public class LongestPalin {

    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        String longest = "";
        int maxLength = 0;
        int start = -1, end = -1;
        for(int i = 0; i < s.length(); i++){
            int oddLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i+1);
            int len = Math.max(oddLen, evenLen);
            if(len > maxLength){
                maxLength = len;
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j - i -1;
    }

}
