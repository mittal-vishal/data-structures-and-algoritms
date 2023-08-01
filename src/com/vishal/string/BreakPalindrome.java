package com.vishal.string;

public class BreakPalindrome {

    public String breakPalindrome(String palindrome) {
        int i = -1;
        if(palindrome.length() < 2){
            return "";
        }
        for(int j = 0; j < palindrome.length()/2; j++){
            if(palindrome.charAt(j) != 'a'){
                i = j;
                break;
            }
        }
        char[] palin = palindrome.toCharArray();
        if(i != -1 && i < palindrome.length()){
            palin[i] = 'a';
            return String.valueOf(palin);
        }else{
            palin[palindrome.length()-1] = 'b';
            return String.valueOf(palin);
        }
    }

}
