package com.vishal.microsoft;

public class MyAtoi {

    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int idx = 0;
        int n = s.length();
        while(idx < n && s.charAt(idx) == ' '){
            idx++;
        }
        if(idx < n && (s.charAt(idx) == '+' || s.charAt(idx) == '-')){
            sign = s.charAt(idx) == '+' ? 1 : -1;
            idx++;
        }

        while(idx < n){
            char curr = s.charAt(idx++);
            if(!Character.isDigit(curr)){
                break;
            }
            int digit = curr - '0';
            //Check overflow and underflow
            if(result > Integer.MAX_VALUE / 10 ||
                    result < Integer.MIN_VALUE * 10 ||
                    result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10 ||
                    result == Integer.MIN_VALUE*10 && digit < Integer.MIN_VALUE % 10){
                return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            result = 10 * result + digit;
        }
        return sign * result;
    }

}
