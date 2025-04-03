package com.vishal.google;

public class NumberOfDigitOne {

    public int countDigitOne(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i *= 10){
            int div = i * 10;
            int quo = n / div;
            int rem = n % div;
            ans += quo * i;
            if(rem >= i){
                ans += Math.min(i, rem-i+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 13;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        System.out.println(numberOfDigitOne.countDigitOne(n));
    }

}
