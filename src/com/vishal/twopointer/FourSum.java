package com.vishal.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                for(int j = i + 1; j < nums.length - 2; j++){
                    if(j == i+1 || nums[j] != nums[j-1]){
                        findQuadUsingTwoPointers(nums, i, j, target, quadruplets);
                    }
                }
            }
        }
        return quadruplets;
    }

    private void findQuadUsingTwoPointers(int[] arr, int first, int second, int target, List<List<Integer>> quadruplets){
        int left = second + 1;
        int right = arr.length - 1;
        int sum = -1;
        while(left < right){
            sum = arr[first] + arr[second] + arr[left] + arr[right];
            if(sum == target){
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;right--;
                while(left < right && arr[left] == arr[left-1]){
                    left++;
                }
                while(left < right && arr[right] == arr[right+1]){
                    right--;
                }
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
    }

}
