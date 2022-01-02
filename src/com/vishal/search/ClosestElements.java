package com.vishal.search;

import java.util.ArrayList;
import java.util.List;

public class ClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> closestElement = new ArrayList<>();
        int beg = 0;
        int end = arr.length - k;
        while(beg < end){
            int mid = beg + (end-beg)/2;

            if(x - arr[mid] > arr[mid + k] - x){
                beg = mid + 1;
            }else{
                end = mid;
            }
        }
        for(int i = beg; i < (beg + k); i++){
            closestElement.add(arr[i]);
        }
        return closestElement;
    }

}
