package com.vishal.google;

public class AddDigits {

    public int addDigits(int num) {
        while(num > 9){
            int sumOfDigit = 0;
            while(num > 0){
                sumOfDigit += num % 10;
                num /= 10;
            }
            num = sumOfDigit;
        }
        return num;
    }

}
