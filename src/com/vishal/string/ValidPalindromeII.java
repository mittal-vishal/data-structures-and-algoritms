package com.vishal.string;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int n = s.length() - 1;
        return validPalindrome(s, 0, n, false);
    }

    private boolean validPalindrome(String s, int left, int right, boolean isSkip){
        if(left > right){
            return true;
        }
        if(s.charAt(left) == s.charAt(right)){
            return validPalindrome(s, left + 1, right - 1, isSkip);
        }else if(!isSkip){
            return validPalindrome(s, left + 1, right, !isSkip) ||
                    validPalindrome(s, left, right - 1, !isSkip);
        }else{
            return false;
        }
    }

}
