package com.vishal.string;

public class LongestHappyPrefixKMP {

    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        generateLPS(s, lps);
        int max = lps[s.length()-1];
        return s.substring(0, max);
    }

    private void generateLPS(String s, int[] lps){
        int i = 0;
        int j = 1;
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0){
                    lps[j] = 0;
                    j++;
                }else{
                    i = lps[i-1];
                }
            }
        }
    }

}
