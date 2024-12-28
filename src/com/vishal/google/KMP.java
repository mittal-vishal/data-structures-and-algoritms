package com.vishal.google;

public class KMP {

    public static void main(String[] args) {
        String s = "ababcabcabababd";
        String p = "ababd";
        System.out.println(strStr(s,p));
    }

    public static int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] lps = new int[needle.length()];
        getLPS(needle, lps);
        while(i < haystack.length() && j < needle.length()){
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
                return i-j;
            }
        }
        return -1;
    }

    private static void getLPS(String needle, int[] lps){
        int i = 0;
        int j = 1;
        lps[0] = 0;
        while(j < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
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
