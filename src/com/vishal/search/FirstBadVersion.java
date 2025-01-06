package com.vishal.search;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int beg = 1;
        int end = n;
        int res = 0;
        while(beg <= end){
            int guess = beg + (end-beg)/2;
            if(isBadVersion(guess)){
                res = guess;
                end = guess-1;
            }else{
                beg = guess+1;
            }
        }
        return res;
    }

    private boolean isBadVersion(int n){
        return true;
    }

}
