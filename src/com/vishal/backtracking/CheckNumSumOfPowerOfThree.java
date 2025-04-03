package com.vishal.backtracking;

public class CheckNumSumOfPowerOfThree {

    private int n;

    public boolean checkPowersOfThree(int n) {
        this.n = n;
        return backtrack(0, 0);
    }

    private boolean backtrack(int i, int curr){
        if(curr == n){
            return true;
        }else if(curr > n || Math.pow(3,i) > n){
            return false;
        }
        //include
        if(backtrack(i+1, curr + (int)Math.pow(3,i))){
            return true;
        }
        //exclude
        return backtrack(i+1, curr);
    }

}
