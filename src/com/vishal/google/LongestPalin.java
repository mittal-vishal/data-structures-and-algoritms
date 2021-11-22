package com.vishal.google;

public class LongestPalin {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int maxLen = 0;
        String longestPalin = "";
        for(int i = 0; i < s.length();i++){
            String currOddPalin = expandAroundIndex(s, i, true);
            String currEvenPalin = expandAroundIndex(s, i, false);
            if(currOddPalin.length() > maxLen){
                maxLen = currOddPalin.length();
                longestPalin = currOddPalin;
            }
            if(currEvenPalin.length() > maxLen){
                maxLen = currEvenPalin.length();
                longestPalin = currEvenPalin;
            }
        }
        return longestPalin;
    }

    private String expandAroundIndex(String s, int idx, boolean isOdd){
        int i = idx;
        int j = -1;
        if(isOdd){
            j = idx;
        }else{
            j = i + 1;
        }

        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;j++;
        }
        i++;

        return s.substring(i, j);
    }

}
