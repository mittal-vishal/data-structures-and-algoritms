package com.vishal.search;

public class Sqrt {

    public int mySqrt(int x) {
        long input = (long)x;
        if(x <= 1){
            return x;
        }
        int result = 0;
        long beg = 1;
        long end = x;
        long target = x;
        while(beg <= end){
            long mid = beg + (end - beg)/2;
            if(mid*mid <= target){
                result = (int) mid;
                beg = mid+1;
            }else{
                end = mid-1;
            }
        }
        return result;
    }

}
