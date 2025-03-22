package com.vishal.string;

public class RotateString {

    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        s = s + s;
        int[] lps = new int[goal.length()];
        buildLps(goal, lps);
        int i = 0;
        int j = 0;
        while(i < s.length()){
            if(s.charAt(i) == goal.charAt(j)){
                i++;
                j++;
            }else if(j != 0){
                j = lps[j-1];
            }else{
                i++;
            }
            if(j == goal.length()){
                return true;
            }
        }
        return false;
    }

    private void buildLps(String s, int[] lps){
        int i = 0;
        int j = 1;
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }else if(i != 0){
                i = lps[i-1];
            }else{
                j++;
            }
        }
    }

}
