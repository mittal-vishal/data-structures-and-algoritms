package com.vishal.twopointer;

public class LongestMountain {

    public int longestMountain(int[] arr) {
        int result = 0;
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int j = i;
            int count = 1;
            boolean isDecl = false;
            //increasing
            while(j < n && arr[j] > arr[j-1]){
                count++;
                j++;
            }
            //decreasing
            while(i != j && j < n && arr[j] < arr[j-1]){
                count++;
                j++;
                isDecl = true;
            }
            if(count >= 3 && isDecl){
                result = Math.max(result, count);
                j--;
            }
            i = j;
        }
        return result;
    }

}
