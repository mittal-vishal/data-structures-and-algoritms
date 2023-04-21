package com.vishal.string;

public class AddTwoString {

    private String addStrings(String X, String Y) {
        int i = X.length()-1;
        int j = Y.length()-1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(i >= 0 || j >= 0){
            int digit1 = i >= 0 ? X.charAt(i--)-'0': 0;
            int digit2 = j >= 0 ? Y.charAt(j--)-'0': 0;
            int remainder = (digit1 + digit2 + carry)%10;
            result.append(remainder);
            carry = (digit1 + digit2 + carry)/10;
        }
        if(carry > 0){
            result.append(carry);
        }
        String finalResult = result.reverse().toString();
        finalResult = trimInitialZero(finalResult);
        if(finalResult.length() == 0){
            return "0";
        }
        return finalResult;
    }

    private String trimInitialZero(String s){
        int i = 0;
        for(;i < s.length(); i++){
            if(s.charAt(i) != '0'){
                break;
            }
        }
        return s.substring(i);
    }

}
