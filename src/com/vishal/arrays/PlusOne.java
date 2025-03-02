package com.vishal.arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        boolean isOneAdded = false;
        for(int i = n-1; i >= 0; i--){
            int one = !isOneAdded ? 1 : 0;
            int res = (digits[i] + carry + one) % 10;
            carry = (digits[i] + carry + one) / 10;
            digits[i] = res;
            isOneAdded = true;
        }
        if(carry != 0){
            digits = new int[n+1];
            digits[0] = carry;
        }
        return digits;
    }

}
