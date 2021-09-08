package com.vishal.sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmallestKPositiveNumber {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        Set<Integer> existedNumSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i + 1 != nums[i] && k-- > 0){
                missingNumbers.add(i+1);
                existedNumSet.add(nums[i]);
            }
        }
        int nextSmallestNum = nums.length + 1;
        while(k > 0){
            if(!existedNumSet.contains(nextSmallestNum)){
                missingNumbers.add(nextSmallestNum);
                k--;
            }
            nextSmallestNum++;
        }
        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        System.out.print(findNumbers(nums, 3));
    }

}
