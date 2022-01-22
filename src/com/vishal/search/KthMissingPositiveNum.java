package com.vishal.search;

public class KthMissingPositiveNum {

    public int findKthPositive(int[] arr, int k) {
        if(k < arr[0]){
            return k;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if((arr[mid] - (mid + 1)) < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        left--;
        int currMissing = arr[left] - (left + 1);
        return arr[left] + (k - currMissing);
    }

}
