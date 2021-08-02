package com.vishal.recursion;

public class SortedOrNot {

    public boolean isSorted(int[] arr, int i, int n){
        if(i == n-1){
            return true;
        }else if(arr[i] > arr[i+1]){
            return false;
        }else{
            return isSorted(arr, i+1, n);
        }
    }

}
