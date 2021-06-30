package com.vishal.twopointer;

import java.util.*;

public class TripletSumZero {

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> tripletSet = new HashSet<>();
        if(nums == null || nums.length == 0) {
            return new ArrayList<>(tripletSet);
        }
        Arrays.sort(nums);
        int left = -1, right = -1;
        for(int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    tripletSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else{
                    right--;
                }
            }

        }
        return new ArrayList(tripletSet);
    }

    public static List<List<Integer>> threeSumConstantSpace(int[] nums) {
        List<List<Integer>> tripleNumsList = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int firstNum = 0, left = 0, right = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i-1]){
                firstNum = nums[i];
                left = i + 1;
                right = nums.length - 1;
                while(left < right){
                    if(firstNum + nums[left] + nums[right] == 0){
                        tripleNumsList.add(Arrays.asList(firstNum, nums[left++], nums[right--]));
                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }else if(firstNum + nums[left] + nums[right] < 0){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return tripleNumsList;
    }

    public static void main(String[] args) {
        int[] arr = {-5, 2, -1, -2, 3};
        System.out.print(threeSum(arr));
    }

}
