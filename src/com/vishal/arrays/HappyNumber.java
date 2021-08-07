package com.vishal.arrays;

import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(true){
            int squareSumDigit = 0;
            while(n > 0){
                squareSumDigit += (n%10)*(n%10);
                n /= 10;
            }
            if(squareSumDigit == 1){
                return true;
            }
            if(set.contains(squareSumDigit)){
                return false;
            }
            set.add(squareSumDigit);
            n = squareSumDigit;
        }
    }

}
