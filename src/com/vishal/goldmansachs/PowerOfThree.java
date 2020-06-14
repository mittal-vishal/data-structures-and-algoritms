package com.vishal.goldmansachs;

public class PowerOfThree {

	public boolean isPowerOfThree(int n) {
        if(n == 0){
            return false;
        }
        double num = n;
        boolean isPowerThree = true;
        while(num != 1){
            num = num / 3;
            if(num != 1 && num % 3 != 0){
                isPowerThree =  false;
                break;
            }
        }
        return isPowerThree;
        
    }

}
