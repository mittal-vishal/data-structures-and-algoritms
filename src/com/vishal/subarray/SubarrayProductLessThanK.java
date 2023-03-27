package com.vishal.subarray;

import java.util.ArrayList;
import java.util.List;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarraysBrute(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int product = 1;
            for(int j = i; j < arr.length; j++){
                product = product * arr[j];
                if(product < target){
                    List<Integer> innerList = new ArrayList<>();
                    for(int k = i; k <= j; k++){
                        innerList.add(arr[k]);
                    }
                    subarrays.add(innerList);
                }
                else{
                    break;
                }
            }
        }
        return subarrays;
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        double prod = 1;
        int left = 0, right = 0;
        while(right < arr.length){
            //Expand the window
            prod *= arr[right++];
            //Shrink the window
            while(prod >= target && left < right){
                prod /= arr[left++];
            }
            List<Integer> temp = new ArrayList<>();
            for(int i = right - 1; i >= left; i--){
                temp.add(arr[i]);
                subarrays.add(new ArrayList<>(temp));
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        int[] arr = {10,5,3,6};
        int target = 100;
        System.out.print(findSubarrays(arr, target));
    }
}