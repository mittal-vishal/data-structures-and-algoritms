package com.vishal.google;

import java.util.ArrayList;
import java.util.Arrays;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] != b[0]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1];
            }
        });
        //extract second dimention, and do LIS
        int n = envelopes.length;
        int[] secondDim = new int[n];
        for(int i = 0; i < n; i++){
            secondDim[i] = envelopes[i][1];
        }
        return lis(secondDim);
    }

    private int lis(int[] nums){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > temp.get(temp.size()-1)){
                temp.add(nums[i]);
            }else{
                int idx = binarySearch(temp, nums[i]);
                temp.set(idx, nums[i]);
            }
        }
        return temp.size();
    }

    private int binarySearch(ArrayList<Integer> temp, int num){
        int beg = 0;
        int end = temp.size()-1;
        while(beg < end){
            int mid = beg + (end-beg)/2;
            if(num == temp.get(mid)){
                return mid;
            }else if(num > temp.get(mid)){
                beg = mid+1;
            }else{
                end = mid;
            }
        }
        return beg;
    }

}
