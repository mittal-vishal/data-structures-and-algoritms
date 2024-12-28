package com.vishal.string;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int lastIdx = getRidFromEndSpace(s);
        int i = lastIdx;
        while(i >= 0 && s.charAt(i) != ' '){
            i--;
        }
        return lastIdx-i;
    }

    private int getRidFromEndSpace(String s){
        int i = s.length()-1;
        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        }
        return i;
    }

}
