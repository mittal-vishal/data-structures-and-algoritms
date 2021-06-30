package com.vishal.twopointer;

import java.util.Arrays;

class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        int left = -1, right = -1;
        for(int i = 0; i < arr.length - 2; i++){
            left = i + 1;
            right = arr.length - 1;
            while(left < right){
                if(arr[i] + arr[left] + arr[right] < target){
                    count += (right - left);
                    left++;
                }else{
                    right--;
                }
            }
        }
        return count;
    }
}
