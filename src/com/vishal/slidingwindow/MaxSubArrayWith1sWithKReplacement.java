package com.vishal.slidingwindow;

public class MaxSubArrayWith1sWithKReplacement {

    public static int findLength(int[] arr, int k) {
        int occuranceOnes = 0;
        int start = 0, end = 0;
        int largest = Integer.MIN_VALUE;
        while(end < arr.length){
            if(arr[end] == 1){
                occuranceOnes++;
            }
            end++;
            if((end - start - occuranceOnes) > k){
                if(arr[start++] == 1){
                    occuranceOnes--;
                }
            }
            largest = Math.max(largest, end - start);
        }
        return largest;
    }

}
