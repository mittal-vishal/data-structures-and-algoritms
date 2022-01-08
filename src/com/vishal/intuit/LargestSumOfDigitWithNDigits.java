package com.vishal.intuit;

import java.util.Stack;

public class LargestSumOfDigitWithNDigits {

    private long sumDigit(int n, int s){
        long ans = 0l;
        Stack<Integer> numStack = new Stack<>();
        while(n-- > 0){
            for(int i = 9; i >= 0; i--){
                if(s >= i){
                    s -= i;
                    numStack.push(i);
                    break;
                }
            }
        }
        if(s > 0){
            return -1l;
        }
        int pow = 0;
        while(!numStack.isEmpty()){
            ans += numStack.pop() * Math.pow(10, pow);
            pow++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        int s = 15;
        LargestSumOfDigitWithNDigits largest = new LargestSumOfDigitWithNDigits();
        long ans = largest.sumDigit(n, s);
        System.out.println(ans);
    }

}
