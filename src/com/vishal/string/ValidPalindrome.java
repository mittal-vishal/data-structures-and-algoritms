package com.vishal.string;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while(start < end){
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = ".,aa";
        System.out.print(isPalindrome(s));
    }

}
