package com.vishal.google;

public class ShortestPalin {

    public static String shortestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        int suffixLen = generateLPS(s);
        String revStr = new StringBuilder(s).reverse().substring(0, s.length() - suffixLen);
        return new StringBuilder(revStr).append(s).toString();
    }

    private static int generateLPS(String s){
        StringBuilder revStr = new StringBuilder(s).reverse();
        s = new StringBuilder(s).append('#').append(revStr).toString();
        int[] lps = new int[s.length()];
        int i = 0;
        lps[0] = 0;
        int j = 1;
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i - 1];
                }
            }
        }
        return lps[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "aabba"; //a a b b a # a b b a a
        System.out.print(shortestPalindrome(s));
    }

    public String shortestPalindromee(String s) {
        if(s.length() < 2){
            return s;
        }
        int max = 0;
        for(int i = 0; i < s.length()/2; i++){
            int oddLength = expandAroundCenter(s, i, i);
            int evenLength = expandAroundCenter(s, i, i+1);
            int length = Math.max(oddLength, evenLength);
            if(length > max){
                max = length;
            }
        }
        if(max != -1){
            String suffix = s.substring(max);
            return new StringBuilder(suffix).reverse().append(s).toString();
        }
        return s;
    }

    private int expandAroundCenter(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(i == -1){
            return j - i - 1;
        }else{
            return -1;
        }
    }

}
