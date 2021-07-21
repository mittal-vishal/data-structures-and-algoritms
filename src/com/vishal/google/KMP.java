package com.vishal.google;

public class KMP {

    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        int[] lps = new int[needle.length()];
        createPrefixTable(needle, lps);
        int j = 0;
        int i = 0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                if(j == 0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
            if(j == needle.length()){
                return (i - j);
            }
        }
        return -1;
    }

    private void createPrefixTable(String p, int[] lps){
        int i = 0;
        lps[0] = 0;
        int j = 1;
        while(j < p.length()){
            if(p.charAt(i) == p.charAt(j)){
                lps[j] = i+1;
                j++;
                i++;
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
