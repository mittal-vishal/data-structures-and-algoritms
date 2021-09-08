package com.vishal.sorting;

import java.util.HashSet;
import java.util.Set;

public class FindMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        Set<Integer> existedNumSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i + 1 != nums[i] && !existedNumSet.contains(i+1)){
                return i + 1;
            }else{
                existedNumSet.add(nums[i]);
            }
        }
        int nextSmallestNum = nums.length + 1;
        while(existedNumSet.contains(nextSmallestNum)){
            nextSmallestNum++;
        }
        return nextSmallestNum;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
