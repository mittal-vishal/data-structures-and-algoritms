package com.vishal.string;

public class MultiplyTwoStrings {

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];
        int level = 0;
        for(int j = len2-1; j >= 0; j--){
            int num2Digit = num2.charAt(j)-'0';
            int carry = 0;
            int k = len1+len2-1-level;
            for(int i = len1-1; i >= 0; i--){
                int num1Digit = num1.charAt(i)-'0';
                int product = (num2Digit*num1Digit) + carry + result[k];
                int remainder = product%10;
                result[k--] = remainder;
                carry = product/10;
                if(carry > 0 && i == 0){
                    result[k--] = carry;
                }
            }
            level++;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < result.length && result[i] == 0){
            i++;
        }
        while(i < result.length){
            sb.append(result[i++]);
        }
        if(sb.length() == 0) sb.append("0");
        return sb.toString();
    }

}
