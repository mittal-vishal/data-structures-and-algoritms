package com.vishal.search;

public class GuessNumber {

    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while(start <= end){
            int mid = start + (end - start)/2;
            int guessNum = guess(mid);
            if(guessNum == 0){
                return mid;
            }else if(guessNum == 1){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    private int guess(int num){
        //Return -1, 0, 1
        return 1;
    }

}
