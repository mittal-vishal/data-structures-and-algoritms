package com.vishal.microsoft;

public class ArrSumZero {

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int idx = 0;
        int element = 1;
        while(n > 0){
            if(n % 2 == 0){
                ans[idx++] = element;
                ans[idx++] = element*(-1);
                n -= 2;
            }else{
                ans[idx++] = 0;
                n -= 1;
            }
            element++;
        }
        return ans;
    }

}
