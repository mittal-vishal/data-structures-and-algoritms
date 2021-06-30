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
        List<List<Integer>> result = new ArrayList<>();
        int right = 0; int left = 0;
        double prod = 1;
        while(right < arr.length){
            prod *= arr[right++];
            while(prod >= target){
                prod /= (arr[left++]);
            }
            List<Integer> innerList = new ArrayList();
            for(int i = (right - 1); i >= left; i--) {
                innerList.add(arr[i]);
                result.add(new ArrayList<>(innerList));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 10};
        int target = 30;
        System.out.print(findSubarrays(arr, target));
    }
}