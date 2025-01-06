package com.vishal.arrays;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        if(Math.ceil(sqrt) == Math.floor(sqrt)){
            return true;
        }else{
            return false;
        }
    }

}
