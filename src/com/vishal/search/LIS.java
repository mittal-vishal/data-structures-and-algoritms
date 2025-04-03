package com.vishal.search;

import java.util.ArrayList;

public class LIS {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > temp.get(temp.size()-1)){
                temp.add(nums[i]);
            }else{
                int index = binarySearch(temp, nums[i]);
                temp.set(index, nums[i]);
            }
        }
        return temp.size();
    }

    private int binarySearch(ArrayList<Integer> temp, int num){
        int beg = 0;
        int end = temp.size()-1;
        while(beg < end){
            int mid = beg + (end-beg)/2;
            if(temp.get(mid) == num){
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
