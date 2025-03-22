package com.vishal.google;

public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {
        int subtraction = 0;
        if(dividend < 0){
            subtraction++;
            dividend = -dividend;
        }
        if(divisor < 0){
            subtraction++;
            divisor = -divisor;
        }
        int result = 0;
        while(dividend >= divisor){
            int count = 1;
            int sum = divisor;
            while(sum <= (dividend-sum)){
                sum += sum;
                count += count;
            }
            dividend -= sum;
            result += count;
        }
        if(subtraction == 1){
            result = -result;
        }
        return result;
    }

}
