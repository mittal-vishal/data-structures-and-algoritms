package com.vishal.search;

public class KthMissingPositiveNum {

    public int findKthPositive(int[] arr, int k) {
        int beg = 0;
        int end = arr.length - 1;
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            int missingElement = arr[mid] - (mid+1);
            if(missingElement < k){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return beg + k;
    }

}
