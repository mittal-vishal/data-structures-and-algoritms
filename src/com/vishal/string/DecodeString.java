package com.vishal.string;

public class DecodeString {

    public String decodeAtIndex(String s, int k) {
        long size = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                size++;
            }else{
                size *= (ch-'0');
            }
        }
        for(int i = s.length()-1; i >= 0; i--){
            char ch = s.charAt(i);
            k %= size;
            if(k == 0 && Character.isLetter(ch)){
                return String.valueOf(ch);
            }else if(Character.isDigit(ch)){
                size /= (ch-'0');
            }else{
                size--;
            }
        }
        return null;
    }

}
