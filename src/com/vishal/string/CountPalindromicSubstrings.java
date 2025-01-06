package com.vishal.string;

public class CountPalindromicSubstrings {

    private int count;

    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++){
            expandAroundMiddle(i, i, s);
            expandAroundMiddle(i, i+1, s);
        }
        return count;
    }

    private void expandAroundMiddle(int i, int j, String s){
        int left = 0;
        int right = s.length()-1;
        while(i >= left && j <= right){
            if(s.charAt(i) == s.charAt(j)){
                i--;
                j++;
                count++;
            }else{
                break;
            }
        }
    }

}
