package com.vishal.string;

public class ReverseWords {

    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        int strEnd = s.length()-1;
        int nextStart = -1;
        while(i >= 0){

            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }

            if(i < 0 && sb.charAt(sb.length() - 1) == ' '){
                sb.deleteCharAt(sb.length() - 1);
            }

            strEnd = i;

            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }

            nextStart = i-1;

            for(int j = i+1; j <= strEnd; j++){
                sb.append(s.charAt(j));
            }

            i = nextStart;

            if(i >= 0){
                sb.append(' ');
            }
        }
        return sb.toString();
    }

}
