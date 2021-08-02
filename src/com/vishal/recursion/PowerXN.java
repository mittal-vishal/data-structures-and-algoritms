package com.vishal.recursion;

public class PowerXN {

    public double myPow(double x, int n) {
        // X^0 = 1
        if(n == 0){
            return 1;
        }
        // 1^INF = 1 and (-1)^INF = 1
        if(n == Integer.MIN_VALUE && Math.abs(x) == 1){
            return Math.abs(x);
        }
        // x^INF = 0 where x != 1
        else if(n == Integer.MIN_VALUE){
            return 0;
        }
        //For negative case x^-1 = 1/x
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        return getExponent(x, n);
    }

    private double getExponent(double x, int n){
        if(n == 0){
            return 1;
        }
        double nextExp = getExponent(x, n/2);
        if(n % 2 == 1){
            return x *nextExp*nextExp;
        }else{
            return nextExp*nextExp;
        }
    }

}
